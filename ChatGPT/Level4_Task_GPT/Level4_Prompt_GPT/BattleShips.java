package ChatGPT.Level4_Task_GPT.Level4_Prompt_GPT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The BattleShips class represents a simple Battleship game with a graphical user interface.
 * It allows the user to place ships on a 10x10 grid following specific rules.
 * The user can repeat the ship placement process exactly two times to place three ships in total.
 */
public class BattleShips {
    private JFrame frame;
    private JPanel gridPanel;

    private JButton[][] gridButtons;
    private int shipsPlaced;
    private int iterationCounter;

    private JButton firstClickedButton;
    private JButton secondClickedButton;

    /**
     * Constructor to initialize the main frame and grid for the Battleship game.
     */
    public BattleShips() {
        // Create the main frame
        frame = new JFrame("BattleShips Game");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the grid panel
        gridPanel = new JPanel(new GridLayout(10, 10));
        initializeGrid();

        // Add the grid panel to the frame
        frame.getContentPane().add(gridPanel);

        // Initialize ships placed counter and iteration counter
        shipsPlaced = 0;
        iterationCounter = 0;

        // Display the frame
        frame.setVisible(true);
    }

    /**
     * Initializes the grid by creating buttons for each cell.
     */
    private void initializeGrid() {
        gridButtons = new JButton[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));

                // Add ActionListener to handle button click events
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(button);
                    }
                });

                gridPanel.add(button);
                gridButtons[i][j] = button;
            }
        }
    }

    /**
     * Handles the button click event by checking if a ship can be placed.
     * If a ship can be placed, it updates the color of the clicked button and tracks the ship placement.
     * If three adjacent squares are selected, it disables all buttons and notifies the user.
     *
     * @param button The clicked button
     */
    private void handleButtonClick(JButton button) {
        // Check if a ship can be placed
        if (shipsPlaced < 3) {
            // Check if the clicked square is valid based on adjacency and rules
            if (isValidClick(button)) {
                // Change the color of the clicked button to blue
                button.setBackground(Color.BLUE);

                // Update the ships placed counter
                shipsPlaced++;

                // Save the first and second clicked buttons
                if (shipsPlaced == 1) {
                    firstClickedButton = button;
                } else if (shipsPlaced == 2) {
                    secondClickedButton = button;
                }

                // Check if three adjacent squares are selected
                if (shipsPlaced == 3) {
                    // Disable all buttons to prevent further ship placement
                    disableAllButtons();
                    JOptionPane.showMessageDialog(frame, "Ship placed successfully!");

                    // Reset ship placement for the next iteration
                    shipsPlaced = 0;
                    iterationCounter++;

                    // Check if the user has placed ships exactly two times
                    if (iterationCounter == 2) {
                        JOptionPane.showMessageDialog(frame, "You have placed three ships two times. Game Over!");
                        System.exit(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid square! Click on a valid square.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "You've already placed three ships!");
        }
    }

    /**
     * Checks if the clicked square is valid based on adjacency and specific rules.
     *
     * @param clickedButton The clicked button
     * @return True if the clicked square is valid, false otherwise
     */
    private boolean isValidClick(JButton clickedButton) {
        if (shipsPlaced == 0) {
            // The first square is always valid
            return true;
        } else if (shipsPlaced == 1) {
            // Only the first square of the three can be clicked freely
            return false;
        } else if (shipsPlaced == 2) {
            // The second square must be adjacent and in the same order
            return areAdjacentAndSameOrder(firstClickedButton, clickedButton);
        } else {
            // Check if the third square is adjacent and in the same order
            return areAdjacentAndSameOrder(secondClickedButton, clickedButton);
        }
    }

    /**
     * Checks if two buttons are adjacent and in the same order either horizontally or vertically.
     *
     * @param button1 The first button
     * @param button2 The second button
     * @return True if the buttons are adjacent and in the same order, false otherwise
     */
    private boolean areAdjacentAndSameOrder(JButton button1, JButton button2) {
        int row1 = -1, col1 = -1;
        int row2 = -1, col2 = -1;

        // Find the row and column of the first clicked button
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gridButtons[i][j] == button1) {
                    row1 = i;
                    col1 = j;
                    break;
                }
            }
        }

        // Find the row and column of the second clicked button
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (gridButtons[i][j] == button2) {
                    row2 = i;
                    col2 = j;
                    break;
                }
            }
        }

        // Check if the squares are adjacent horizontally and in the same order
        return (row1 == row2 && Math.abs(col1 - col2) == 1)
                // Check if the squares are adjacent vertically and in the same order
                || (col1 == col2 && Math.abs(row1 - row2) == 1);
    }

    /**
     * Disables all buttons to prevent further ship placement.
     */
    private void disableAllButtons() {
        // Disable all buttons to prevent further ship placement
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gridButtons[i][j].setEnabled(false);
            }
        }
    }

    /**
     * The main method to launch the BattleShips game.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BattleShips();
            }
        });
    }
}
