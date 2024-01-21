package ChatGPT.Level3_Task_GPT.Level3_Prompt_GPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeGame extends JFrame implements ActionListener, KeyListener {

    private final int GRID_SIZE = 20;
    private final int CELL_SIZE = 20;

    private int[][] grid;
    private int snakeLength;
    private int[] snakeX, snakeY;
    private int direction;
    private boolean running;

    private int appleX, appleY;

    public SnakeGame() {
        // Set up the UI
        setTitle("Snake Game");
        setSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Initialize variables
        grid = new int[GRID_SIZE][GRID_SIZE];
        snakeX = new int[GRID_SIZE * GRID_SIZE];
        snakeY = new int[GRID_SIZE * GRID_SIZE];
        snakeLength = 1;
        direction = KeyEvent.VK_RIGHT;
        running = true;

        // Initialize the snake
        snakeX[0] = GRID_SIZE / 2;
        snakeY[0] = GRID_SIZE / 2;

        // Set up the timer for game ticks
        Timer timer = new Timer(100, this);
        timer.start();

        // Set up keyboard input
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Start the game
        spawnApple();
        setVisible(true);
    }

    private void spawnApple() {
        Random random = new Random();
        do {
            appleX = random.nextInt(GRID_SIZE);
            appleY = random.nextInt(GRID_SIZE);
        } while (grid[appleX][appleY] != 0);
        grid[appleX][appleY] = 2; // 2 represents the apple
    }

    private void move() {
        // Move the snake
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        // Move the head
        switch (direction) {
            case KeyEvent.VK_UP:
                snakeY[0]--;
                break;
            case KeyEvent.VK_DOWN:
                snakeY[0]++;
                break;
            case KeyEvent.VK_LEFT:
                snakeX[0]--;
                break;
            case KeyEvent.VK_RIGHT:
                snakeX[0]++;
                break;
        }

        // Check for collisions
        if (snakeX[0] < 0 || snakeX[0] >= GRID_SIZE || snakeY[0] < 0 || snakeY[0] >= GRID_SIZE) {
            running = false;
            return;
        }

        // Check for apple
        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            snakeLength++;
            spawnApple();
        }

        // Check for collision with tail
        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                running = false;
                return;
            }
        }
    }

    private void render(Graphics g) {
        // Draw the grid
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the snake
        g.setColor(Color.GREEN);
        for (int i = 0; i < snakeLength; i++) {
            g.fillRect(snakeX[i] * CELL_SIZE, snakeY[i] * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        // Draw the apple
        g.setColor(Color.RED);
        g.fillRect(appleX * CELL_SIZE, appleY * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        // Dispose of graphics
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Change direction based on key input
        if ((key == KeyEvent.VK_LEFT) && (direction != KeyEvent.VK_RIGHT)) {
            direction = KeyEvent.VK_LEFT;
        } else if ((key == KeyEvent.VK_RIGHT) && (direction != KeyEvent.VK_LEFT)) {
            direction = KeyEvent.VK_RIGHT;
        } else if ((key == KeyEvent.VK_UP) && (direction != KeyEvent.VK_DOWN)) {
            direction = KeyEvent.VK_UP;
        } else if ((key == KeyEvent.VK_DOWN) && (direction != KeyEvent.VK_UP)) {
            direction = KeyEvent.VK_DOWN;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}
