import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;
    
    private final int TILE_SIZE = 20;
    private final int GRID_SIZE = 20;
    
    private ArrayList<Point> snake;
    private Point gem;
    private char direction = 'R'; // Initial direction is right
    private Timer timer;
    private int score = 0;
    private int highScore = 0;

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        snake = new ArrayList<>();
        snake.add(new Point(5, 5));
        
        spawnGem();
        
        timer = new Timer(150, this);
        timer.start();
        
        addKeyListener(this);
        setFocusable(true);
    }

    private void spawnGem() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(GRID_SIZE);
            y = random.nextInt(GRID_SIZE);
        } while (snake.contains(new Point(x, y)));
        
        gem = new Point(x, y);
    }

    private void move() {
        Point head = snake.get(0);

        switch (direction) {
            case 'U':
                head.y = (head.y - 1 + GRID_SIZE) % GRID_SIZE;
                break;
            case 'D':
                head.y = (head.y + 1) % GRID_SIZE;
                break;
            case 'L':
                head.x = (head.x - 1 + GRID_SIZE) % GRID_SIZE;
                break;
            case 'R':
                head.x = (head.x + 1) % GRID_SIZE;
                break;
        }

        // Check collision with gem
        if (head.equals(gem)) {
            snake.add(new Point(-1, -1)); // Dummy point, will be updated in the next iteration
            spawnGem();
            score++;
            if (score > highScore) {
                highScore = score;
            }
        }

        // Check collision with itself
        if (snake.subList(1, snake.size()).contains(head)) {
            gameOver();
        }

        // Move the snake
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.set(i, snake.get(i - 1));
        }
        snake.set(0, head);
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over!\nScore: " + score + "\nHigh Score: " + highScore);
        resetGame();
    }

    private void resetGame() {
        snake.clear();
        snake.add(new Point(5, 5));
        direction = 'R';
        score = 0;
        spawnGem();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
                if (direction != 'D') direction = 'U';
                break;
            case KeyEvent.VK_S:
                if (direction != 'U') direction = 'D';
                break;
            case KeyEvent.VK_A:
                if (direction != 'R') direction = 'L';
                break;
            case KeyEvent.VK_D:
                if (direction != 'L') direction = 'R';
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw snake
        g.setColor(Color.GREEN);
        for (Point point : snake) {
            g.fillRect(point.x * TILE_SIZE, point.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }

        // Draw gem
        g.setColor(Color.RED);
        g.fillRect(gem.x * TILE_SIZE, gem.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // Draw score
        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, GRID_SIZE * TILE_SIZE + 20);
        g.drawString("High Score: " + highScore, 10, GRID_SIZE * TILE_SIZE + 40);

        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}
