package ChatGPT.Level3_Task_GPT.Level4_Prompt_GPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        initUI();
    }

    private void initUI() {
        setTitle("Snake Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        SnakePanel snakePanel = new SnakePanel();
        add(snakePanel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snakePanel.processKey(e.getKeyCode());
            }
        });

        setFocusable(true);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snakePanel.move();
                snakePanel.checkCollision();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SnakeGame snakeGame = new SnakeGame();
                snakeGame.setVisible(true);
            }
        });
    }
}

class SnakePanel extends JPanel {

    private int gridSize = 20;
    private int snakeSpeed = 10;
    private char currentDirection = 'R';
    private List<Point> snakeBody = new ArrayList<>();
    private int foodX;
    private int foodY;
    private boolean foodEaten = true;

    public SnakePanel() {
        setBackground(Color.BLACK);
        initializeSnake();
        initializeFood();
    }

    public void move() {
        // Update the snake position based on the current direction
        Point newHead = new Point(snakeBody.get(0));
        switch (currentDirection) {
            case 'R':
                newHead.x = (newHead.x + snakeSpeed) % getWidth();
                break;
            case 'L':
                newHead.x = (newHead.x - snakeSpeed + getWidth()) % getWidth();
                break;
            case 'U':
                newHead.y = (newHead.y - snakeSpeed + getHeight()) % getHeight();
                break;
            case 'D':
                newHead.y = (newHead.y + snakeSpeed) % getHeight();
                break;
        }

        // Check if the snake has eaten the food
        if (newHead.x == foodX && newHead.y == foodY) {
            foodEaten = true;
            initializeFood();
            snakeBody.add(0, newHead);
        } else {
            // Remove the last segment if the snake hasn't eaten
            snakeBody.add(0, newHead);
            snakeBody.remove(snakeBody.size() - 1);
        }

        // Repaint the panel to reflect the changes
        repaint();
    }

    public void processKey(int keyCode) {
        // Update the current direction based on user input
        switch (keyCode) {
            case KeyEvent.VK_W:
                if (currentDirection != 'D') {
                    currentDirection = 'U';
                }
                break;
            case KeyEvent.VK_A:
                if (currentDirection != 'R') {
                    currentDirection = 'L';
                }
                break;
            case KeyEvent.VK_S:
                if (currentDirection != 'U') {
                    currentDirection = 'D';
                }
                break;
            case KeyEvent.VK_D:
                if (currentDirection != 'L') {
                    currentDirection = 'R';
                }
                break;
        }
    }

    public void checkCollision() {
        // Check if the snake has collided with itself
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeBody.get(0).equals(snakeBody.get(i))) {
                // Game over logic (you can customize this part)
                JOptionPane.showMessageDialog(this, "Game Over!\nYour score: " + (snakeBody.size() - 1));
                System.exit(0);
            }
        }

        // Check if the first green square collides with the rest of the green squares
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeBody.get(0).equals(snakeBody.get(i))) {
                // Remove all other green squares except the first one
                for (int j = snakeBody.size() - 1; j > i; j--) {
                    snakeBody.remove(j);
                }
                break;
            }
        }
    }

    private void initializeSnake() {
        // Initialize the snake with a default size and position
        snakeBody.add(new Point(50, 50));
        snakeBody.add(new Point(40, 50));
        snakeBody.add(new Point(30, 50));
    }

    private void initializeFood() {
        if (foodEaten) {
            Random rand = new Random();
            int gridWidth = getWidth() / gridSize;
            int gridHeight = getHeight() / gridSize;

            if (gridWidth <= 0 || gridHeight <= 0) {
                // Ensure positive grid dimensions
                return;
            }

            do {
                foodX = rand.nextInt(gridWidth) * gridSize;
                foodY = rand.nextInt(gridHeight) * gridSize;
            } while (snakeBody.contains(new Point(foodX, foodY)));


            foodEaten = false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the grid
        g.setColor(Color.GRAY);
        for (int i = 0; i < getWidth(); i += gridSize) {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int i = 0; i < getHeight(); i += gridSize) {
            g.drawLine(0, i, getWidth(), i);
        }

        // Draw the snake
        g.setColor(Color.GREEN);
        for (Point point : snakeBody) {
            g.fillRect(point.x, point.y, gridSize, gridSize);
        }

        // Draw the food
        g.setColor(Color.RED);
        g.fillRect(foodX, foodY, gridSize, gridSize);
    }
}
