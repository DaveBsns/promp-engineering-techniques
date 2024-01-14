package Bard.Level4_Task_Bard.Level2_Prompt_Bard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleShips extends JFrame {

    private static final int GRID_SIZE = 10;

    private JButton[][] buttons;
    private Ship[] playerShips;
    private Ship[] computerShips;

    public BattleShips() {
        setTitle("Battleships");
        setSize(500, 500);
        setLayout(new GridLayout(GRID_SIZE + 1, GRID_SIZE));

        buttons = new JButton[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ButtonListener(i, j));
                add(buttons[i][j]);
            }
        }

        // Initialize player and computer ships
        playerShips = new Ship[3];
        computerShips = new Ship[3];

        // Place player ships
        placePlayerShips();

        // Computer places its ships randomly
        placeComputerShips();
    }

    private void placePlayerShips() {
        // Get user input for ship coordinates and orientation
        for (int i = 0; i < playerShips.length; i++) {
            int shipLength = 3;
            String orientation;
            int row, col;

            do {
                System.out.print("Enter the row and column coordinates for ship " + (i + 1) + ": ");
                Scanner scanner = new Scanner(System.in);
                row = scanner.nextInt();
                col = scanner.nextInt();

                System.out.print("Enter the orientation (vertical or horizontal): ");
                orientation = scanner.next();
            } while (!isValidShipPlacement(row, col, orientation, shipLength));

            Ship ship = new Ship(row, col, orientation, shipLength);
            playerShips[i] = ship;
        }
    }

    private void placeComputerShips() {
        // Computer randomly generates coordinates and orientations for its ships
        for (int i = 0; i < computerShips.length; i++) {
            int shipLength = 3;
            int row = (int) (Math.random() * GRID_SIZE);
            int col = (int) (Math.random() * GRID_SIZE);
            String orientation = (Math.random() > 0.5) ? "vertical" : "horizontal";

            while (!isValidShipPlacement(row, col, orientation, shipLength)) {
                row = (int) (Math.random() * GRID_SIZE);
                col = (int) (Math.random() * GRID_SIZE);
                orientation = (Math.random() > 0.5) ? "vertical" : "horizontal";
            }

            Ship ship = new Ship(row, col, orientation, shipLength);
            computerShips[i] = ship;
        }

        // Update GUI with computer's ship placements
        for (Ship ship : computerShips) {
            for (int i = 0; i < ship.getLength(); i++) {
                int row = ship.getRow() + (i * ship.getOrientation().equals("vertical") ? 0 : 1);
                int col = ship.getCol() + (i * ship.getOrientation().equals("horizontal") ? 0 : 1);

                buttons[row][col].setText("S");
            }
        }
    }

    // Check if the specified coordinates and orientation are valid for the ship
private boolean isValidShipPlacement(int row, int col, String orientation, int shipLength) {
    // Check if the specified coordinates are within the grid
    if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
        System.out.println("Coordinates must be within the grid");
        return false;
    }

    // Check if the ship won't overlap with other ships
    if (orientation.equals("vertical")) {
        for (int i = 0; i < shipLength; i++) {
            if (buttons[row + i][col].getText() == "S") {
                System.out.println("Ship overlaps with another ship");
                return false;
            }
        }
    } else if (orientation.equals("horizontal")) {
        for (int i = 0; i < shipLength; i++) {
            if (buttons[row][col + i].getText() == "S") {
                System.out.println("Ship overlaps with another ship");
                return false;
            }
        }
    }

    return true;
}

private void updateGUI(int row, int col) {
    // Check if the shot hit a ship
    for (Ship ship : playerShips) {
        if (ship.isHit(row, col)) {
            ship.hit();

            // Update the GUI to mark the hit ship
            for (int i = 0; i < ship.getLength(); i++) {
                int r = ship.getRow() + (i * ship.getOrientation().equals("vertical") ? 0 : 1);
                int c = ship.getCol() + (i * ship.getOrientation().equals("horizontal") ? 0 : 1);

                buttons[r][c].setText("X");

                // Check if all parts of the ship are sunk
                if (!ship.isAlive()) {
                    System.out.println("You sunk a ship!");
                    // TODO: Display a message indicating the sunk ship
                }
            }

            // Check if the player has won
            if (isPlayerWon()) {
                System.out.println("Congratulations! You won the game!");
                // TODO: Display a victory message
                dispose();
            }
            break;
        }
    }

    // If the shot didn't hit a ship, update the GUI to mark it as missed
    if (!isPlayerWon()) {
        buttons[row][col].setText("O");
        System.out.println("Miss!");
    }
}

private boolean isPlayerWon() {
    for (Ship ship : playerShips) {
        if (ship.isAlive()) {
            return false;
        }
    }

    return true;
}

public static void main(String[] args) {
    BattleShips game = new BattleShips();
    game.setVisible(true);
}

private class ButtonListener implements ActionListener {

    private int row, col;

    public ButtonListener(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGUI(row, col);
    }
}
}

