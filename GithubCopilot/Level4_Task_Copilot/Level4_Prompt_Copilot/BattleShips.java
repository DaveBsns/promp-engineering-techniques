package GithubCopilot.Level4_Task_Copilot.Level4_Prompt_Copilot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * The BattleShips class represents a simple battleship game.
 */
public class BattleShips {
    private JFrame frame;
    private JPanel gridPanel;
    private JButton[][] gridButtons;
    private boolean[][] shipPlacement;
    private boolean[][] enemyShipPlacement;
    private int shipCount;
    private int enemyShipCount;
    private boolean isFirstSquareClicked;
    private boolean isEnemyTurn;
    private int lastClickedRow;
    private int lastClickedCol;
    private int repeatCount;

    /**
     * Constructs a BattleShips object and initializes the game.
     */
    public BattleShips() {
        frame = new JFrame("Battle Ships");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        gridPanel = new JPanel(new GridLayout(10, 10));
        gridButtons = new JButton[10][10];
        shipPlacement = new boolean[10][10];
        enemyShipPlacement = new boolean[10][10];
        shipCount = 0;
        enemyShipCount = 0;
        isFirstSquareClicked = false;
        isEnemyTurn = false;
        lastClickedRow = -1;
        lastClickedCol = -1;
        repeatCount = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gridButtons[i][j] = new JButton();
                gridButtons[i][j].addActionListener(new ButtonClickListener(i, j));
                gridPanel.add(gridButtons[i][j]);
            }
        }

        frame.add(gridPanel);
        frame.setVisible(true);
    }

    /**
     * The ButtonClickListener class represents an action listener for the grid buttons.
     */
    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        /**
         * Constructs a ButtonClickListener object with the specified row and column.
         * @param row the row of the button
         * @param col the column of the button
         */
        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        /**
         * Handles the button click event.
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isEnemyTurn) { // Player's turn
                if (!isFirstSquareClicked) {
                    shipPlacement[row][col] = true;
                    gridButtons[row][col].setBackground(Color.BLUE);
                    shipCount++;
                    isFirstSquareClicked = true;
                    lastClickedRow = row;
                    lastClickedCol = col;
                } else if (shipCount < 3 && isAdjacentClicked(row, col) && isSameOrder(row, col)) {
                    shipPlacement[row][col] = true;
                    gridButtons[row][col].setBackground(Color.BLUE);
                    shipCount++;
                    lastClickedRow = row;
                    lastClickedCol = col;
                }

                if (shipCount == 3 && repeatCount < 2) {
                    repeatCount++;
                    shipCount = 0;
                    isFirstSquareClicked = false;
                    lastClickedRow = -1;
                    lastClickedCol = -1;
                    isEnemyTurn = true; // Switch to enemy's turn
                    enemyTurn(); // Call enemy's turn
                }
            }
        }

        /**
         * Checks if an adjacent button has been clicked.
         * @param row the row of the button
         * @param col the column of the button
         * @return true if an adjacent button has been clicked, false otherwise
         */
        private boolean isAdjacentClicked(int row, int col) {
            if (row > 0 && shipPlacement[row - 1][col]) {
                return true;
            }
            if (row < 9 && shipPlacement[row + 1][col]) {
                return true;
            }
            if (col > 0 && shipPlacement[row][col - 1]) {
                return true;
            }
            if (col < 9 && shipPlacement[row][col + 1]) {
                return true;
            }
            return false;
        }

        /**
         * Checks if the button is in the same order as the last clicked button.
         * @param row the row of the button
         * @param col the column of the button
         * @return true if the button is in the same order, false otherwise
         */
        private boolean isSameOrder(int row, int col) {
            if (row == lastClickedRow) {
                if (col == lastClickedCol + 1 || col == lastClickedCol - 1) {
                    return true;
                }
            }
            if (col == lastClickedCol) {
                if (row == lastClickedRow + 1 || row == lastClickedRow - 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Performs the enemy's turn.
     */
    private void enemyTurn() {
        Random random = new Random();
        int row = random.nextInt(10);
        int col = random.nextInt(10);

        if (!isFirstSquareClicked) {
            enemyShipPlacement[row][col] = true;
            gridButtons[row][col].setBackground(Color.RED);
            enemyShipCount++;
            isFirstSquareClicked = true;
            lastClickedRow = row;
            lastClickedCol = col;
        } else if (enemyShipCount < 3 && isAdjacentClicked(row, col) && isSameOrder(row, col)) {
            enemyShipPlacement[row][col] = true;
            gridButtons[row][col].setBackground(Color.RED);
            enemyShipCount++;
            lastClickedRow = row;
            lastClickedCol = col;
        }

        if (enemyShipCount == 3 && repeatCount < 2) {
            repeatCount++;
            enemyShipCount = 0;
            isFirstSquareClicked = false;
            lastClickedRow = -1;
            lastClickedCol = -1;
            isEnemyTurn = false; // Switch to player's turn
        }
    }

    /**
     * The main method creates a new BattleShips object and starts the game.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BattleShips();
            }
        });
    }
}
