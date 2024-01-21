package GithubCopilot.Level3_Task_Copilot.Level3_Prompt_Copilot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class SnakeGame extends JFrame {
    class Snake {
        // Implement the Snake class here
    }

    class Gem {
        // Implement the Gem class here
    }

    private Snake snake;
    private Gem gem; 
    private int score = 0;
    private int highScore = 0;

    public SnakeGame() {
        this.snake = new Snake();
        this.gem = new Gem();

        // Set up the JFrame
        this.setTitle("Snake Game");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Add a KeyListener to control the snake
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                snake.changeDirection(e.getKeyCode());
            }
        });

        // Start the game loop
        while (true) {
            // Move the snake
            snake.move();

            // Check for collision with gem
            if (snake.getHead().equals(gem.getPosition())) {
                // Increase score and grow the snake
                score++;
                snake.grow();
                gem = new Gem(); // Create a new gem
            }

            // Check for collision with self
            if (snake.checkCollision()) {
                // Game over, reset the game
                snake = new Snake();
                score = 0;
            }

            // Update the high score
            if (score > highScore) {
                highScore = score;
            }

            // Redraw the game
            repaint();

            // Pause for a short period
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        // Draw the game elements
        snake.draw(g);
        gem.draw(g);

        // Draw the score
        g.drawString("Score: " + score, 10, 50);
        g.drawString("High Score: " + highScore, 10, 70);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
