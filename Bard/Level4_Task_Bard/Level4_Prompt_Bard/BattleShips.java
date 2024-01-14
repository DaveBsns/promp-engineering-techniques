package Bard.Level4_Task_Bard.Level4_Prompt_Bard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleShips extends JFrame {

    private JButton[][] buttons;
    private JLabel[] labels;
    private int[][] grid;
    private int[][] enemyGrid;
    private boolean[] hit;
    private boolean[] sunk;

    public BattleShips() {
        super("Battleships");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the game grid
        grid = new int[10][10];
        enemyGrid = new int[10][10];
        hit = new boolean[10][10];
        sunk = new boolean[10][10];

        // Create the buttons
        buttons = new JButton[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ButtonListener());
            }
        }

        // Create the labels
        labels = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            labels[i] = new JLabel("");
            labels[i].setFont(new Font("Arial", Font.BOLD, 24));
        }

        // Add the buttons and labels to the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                panel.add(buttons[i][j]);
            }
            panel.add(labels[i]);
        }

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Set the size of the frame
        setSize(500, 500);
        setVisible(true);

        // Place the ships randomly on the enemy grid
        placeShipsRandomly();
    }

    private void placeShipsRandomly() {
        int remainingShips = 10;

        while (remainingShips > 0) {
            int shipLength = 1 + (int) (Math.random() * 4);
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            boolean vertical = Math.random() < 0.5;

            boolean placedSuccessfully = false;
            for (int i = 0; i < shipLength; i++) {
                int curRow = row;
                int curCol = col;

                if (vertical) {
                    if (curRow + i >= 10) {
                        break;
                    }

                    for (int j = 0; j < shipLength; j++) {
                        if (enemyGrid[curRow + i][curCol + j] != 0) {
                            break;
                        }
                    }
                } else {
                    if (curCol + i >= 10) {
                        break;
                    }

                    for (int j = 0; j < shipLength; j++) {
                        if (enemyGrid[curRow + j][curCol + i] != 0) {
                            break;
                        }
                    }
                }

                if (i == shipLength - 1) {
                    for (int j = 0; j < shipLength; j++) {
                        if (vertical) {
                            enemyGrid[row + j][col] = shipLength;
                        } else {
                            enemyGrid[row][col + j] = shipLength;
                        }
                    }

                    placedSuccessfully = true;
                    break;
                }
            }
            if (!placedSuccessfully) {
                break;
            }
    
            remainingShips--;
        }
    }
}