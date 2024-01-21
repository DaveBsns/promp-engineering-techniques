package GithubCopilot.Level3_Task_Copilot.Level2_Prompt_Copilot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGame extends JFrame implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = (WIDTH * HEIGHT) / (DOT_SIZE * DOT_SIZE);
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int appleX;
    private int appleY;
    private int score;

    private Timer timer;
    private boolean inGame;
    private boolean leftDirection;
    private boolean rightDirection;
    private boolean upDirection;
    private boolean downDirection;

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(new TAdapter());

        setFocusable(true);
        setBackground(Color.BLACK);

        initializeGame();

        timer = new Timer(DELAY, this);
        timer.start();

        setVisible(true); // Add this line to make the JFrame visible.
    }

    private void initializeGame() {
        dots = 3;
        score = 0;
        inGame = true;

        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * DOT_SIZE;
            y[i] = 50;
        }

        generateApple();
    }

    private void generateApple() {
        int r = (int) (Math.random() * RAND_POS);
        appleX = r * DOT_SIZE;

        r = (int) (Math.random() * RAND_POS);
        appleY = r * DOT_SIZE;
    }

    private void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            score++;
            generateApple();
        }

        if (x[0] >= WIDTH || x[0] < 0 || y[0] >= HEIGHT || y[0] < 0) {
            inGame = false;
        }

        for (int i = 1; i < dots; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }

        if (!inGame) {
            timer.stop();
        }

        if (inGame) {
            for (int i = dots - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            if (leftDirection) {
                x[0] -= DOT_SIZE;
            }

            if (rightDirection) {
                x[0] += DOT_SIZE;
            }

            if (upDirection) {
                y[0] -= DOT_SIZE;
            }

            if (downDirection) {
                y[0] += DOT_SIZE;
            }
        }
    }

    private void checkCollision() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }
    }

    private void gameOver(Graphics g) {
        String message = "Game Over";
        Font font = new Font("Helvetica", Font.BOLD, 40);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(message, (WIDTH - metrics.stringWidth(message)) / 2, HEIGHT / 2);
        g.drawString("Score: " + score, (WIDTH - metrics.stringWidth("Score: " + score)) / 2, HEIGHT / 2 + 50);
    }

    private void draw(Graphics g) {
        if (inGame) {
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, DOT_SIZE, DOT_SIZE);

            for (int i = 0; i < dots; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
            g.setColor(Color.RED);
                g.fillOval(appleX, appleY, DOT_SIZE, DOT_SIZE);

                for (int i = 0; i < dots; i++) {
                    if (i == 0) {
                        g.setColor(Color.GREEN);
                    } else {
                        g.setColor(Color.WHITE);
                    }

                    g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
                }

                Toolkit.getDefaultToolkit().sync();
            
            gameOver(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move();
            checkCollision();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !rightDirection) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_RIGHT && !leftDirection) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_UP && !downDirection) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if (key == KeyEvent.VK_DOWN && !upDirection) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}
