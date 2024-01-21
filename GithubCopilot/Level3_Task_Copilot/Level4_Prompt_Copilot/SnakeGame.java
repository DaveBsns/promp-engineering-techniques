/**
 * SnakeGame class represents a simple snake game.
 * The snake moves around the grid and collects red quadrats.
 * The game ends if the snake collides with itself.
 */
package GithubCopilot.Level3_Task_Copilot.Level4_Prompt_Copilot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame {
    // Constants
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private static final int GRID_SIZE = 20;
    private static final int INITIAL_DELAY = 100;

    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color SNAKE_COLOR = Color.GREEN;
    private static final Color RED_QUADRAT_COLOR = Color.RED;

    // Snake position and direction
    private static int snakeX = 0;
    private static int snakeY = 0;
    private static int snakeDirection = KeyEvent.VK_RIGHT;

    // Red quadrat position and collection status
    private static int redQuadratX;
    private static int redQuadratY;
    private static boolean redQuadratCollected = false;

    // Snake body positions
    private static List<Integer> snakeXPositions = new ArrayList<>();
    private static List<Integer> snakeYPositions = new ArrayList<>();

    public static void main(String[] args) {
        // Create the game window
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // Create the game panel
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGrid(g);
                drawSnake(g);
                drawRedQuadrat(g);
            }
        };
        panel.setBackground(BACKGROUND_COLOR);
        panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        panel.setFocusable(true);
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeSnakeDirection(e.getKeyCode());
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        // Start the game
        moveSnake(panel);
        spawnRedQuadrat();
    }

    /**
     * Draws the grid on the game panel.
     * @param g The graphics object used for drawing.
     */
    private static void drawGrid(Graphics g) {
        g.setColor(Color.GRAY);
        for (int x = 0; x < FRAME_WIDTH; x += GRID_SIZE) {
            g.drawLine(x, 0, x, FRAME_HEIGHT);
        }
        for (int y = 0; y < FRAME_HEIGHT; y += GRID_SIZE) {
            g.drawLine(0, y, FRAME_WIDTH, y);
        }
    }

    /**
     * Draws the snake on the game panel.
     * @param g The graphics object used for drawing.
     */
    private static void drawSnake(Graphics g) {
        g.setColor(SNAKE_COLOR);
        for (int i = 0; i < snakeXPositions.size(); i++) {
            int x = snakeXPositions.get(i);
            int y = snakeYPositions.get(i);
            g.fillRect(x, y, GRID_SIZE, GRID_SIZE);
        }
    }

    /**
     * Draws the red quadrat on the game panel.
     * @param g The graphics object used for drawing.
     */
    private static void drawRedQuadrat(Graphics g) {
        if (!redQuadratCollected) {
            g.setColor(RED_QUADRAT_COLOR);
            g.fillRect(redQuadratX, redQuadratY, GRID_SIZE, GRID_SIZE);
        }
    }

    /**
     * Moves the snake on the game panel.
     * @param panel The game panel.
     */
    private static void moveSnake(JPanel panel) {
        new Thread(() -> {
            while (true) {
                int newSnakeX = snakeX;
                int newSnakeY = snakeY;

                // Update snake position based on the current direction
                switch (snakeDirection) {
                    case KeyEvent.VK_UP:
                        newSnakeY -= GRID_SIZE;
                        break;
                    case KeyEvent.VK_DOWN:
                        newSnakeY += GRID_SIZE;
                        break;
                    case KeyEvent.VK_LEFT:
                        newSnakeX -= GRID_SIZE;
                        break;
                    case KeyEvent.VK_RIGHT:
                        newSnakeX += GRID_SIZE;
                        break;
                }

                // Wrap snake around the screen if it goes out of bounds
                if (newSnakeX < 0) {
                    newSnakeX = FRAME_WIDTH - GRID_SIZE;
                } else if (newSnakeX >= FRAME_WIDTH) {
                    newSnakeX = 0;
                }

                if (newSnakeY < 0) {
                    newSnakeY = FRAME_HEIGHT - GRID_SIZE;
                } else if (newSnakeY >= FRAME_HEIGHT) {
                    newSnakeY = 0;
                }

                // Check if the snake collects the red quadrat
                if (!redQuadratCollected && newSnakeX == redQuadratX && newSnakeY == redQuadratY) {
                    redQuadratCollected = true;
                    spawnRedQuadrat();
                    snakeXPositions.add(snakeXPositions.get(snakeXPositions.size() - 1));
                    snakeYPositions.add(snakeYPositions.get(snakeYPositions.size() - 1));
                }

                // Check if the snake collides with itself
                if (snakeXPositions.contains(newSnakeX) && snakeYPositions.contains(newSnakeY)) {
                    restartGame(panel);
                    break;
                }

                // Update snake position and body
                snakeX = newSnakeX;
                snakeY = newSnakeY;

                snakeXPositions.add(0, snakeX);
                snakeYPositions.add(0, snakeY);

                if (snakeXPositions.size() > 1) {
                    snakeXPositions.remove(snakeXPositions.size() - 1);
                    snakeYPositions.remove(snakeYPositions.size() - 1);
                }

                // Check if the first green quadrat is colliding with another green quadrat from its "tail"
                if (snakeXPositions.size() > 1 && snakeXPositions.get(0) == snakeXPositions.get(1) && snakeYPositions.get(0) == snakeYPositions.get(1)) {
                    snakeXPositions.remove(0);
                    snakeYPositions.remove(0);
                }

                panel.repaint();

                try {
                    Thread.sleep(INITIAL_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Changes the direction of the snake based on the key pressed.
     * @param keyCode The key code of the pressed key.
     */
    private static void changeSnakeDirection(int keyCode) {
        if (keyCode == KeyEvent.VK_W && snakeDirection != KeyEvent.VK_DOWN) {
            snakeDirection = KeyEvent.VK_UP;
        } else if (keyCode == KeyEvent.VK_S && snakeDirection != KeyEvent.VK_UP) {
            snakeDirection = KeyEvent.VK_DOWN;
        } else if (keyCode == KeyEvent.VK_A && snakeDirection != KeyEvent.VK_RIGHT) {
            snakeDirection = KeyEvent.VK_LEFT;
        } else if (keyCode == KeyEvent.VK_D && snakeDirection != KeyEvent.VK_LEFT) {
            snakeDirection = KeyEvent.VK_RIGHT;
        }
    }

    /**
     * Spawns a red quadrat at a random position on the game panel.
     */
    private static void spawnRedQuadrat() {
        Random random = new Random();
        int maxX = FRAME_WIDTH / GRID_SIZE;
        int maxY = FRAME_HEIGHT / GRID_SIZE;

        // Generate a new position until it is not occupied by the snake or the current red quadrat
        do {
            redQuadratX = random.nextInt(maxX) * GRID_SIZE;
            redQuadratY = random.nextInt(maxY) * GRID_SIZE;
        } while (snakeXPositions.contains(redQuadratX) && snakeYPositions.contains(redQuadratY) || (redQuadratX == snakeX && redQuadratY == snakeY));

        redQuadratCollected = false;
    }

    /**
     * Restarts the game by resetting the snake and red quadrat positions.
     * @param panel The game panel.
     */
    private static void restartGame(JPanel panel) {
        snakeX = 0;
        snakeY = 0;
        snakeDirection = KeyEvent.VK_RIGHT;
        snakeXPositions.clear();
        snakeYPositions.clear();
        redQuadratCollected = false;
        spawnRedQuadrat();
        panel.repaint();
    }
}
