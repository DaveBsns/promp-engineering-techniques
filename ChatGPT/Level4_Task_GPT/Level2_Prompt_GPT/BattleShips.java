package ChatGPT.Level4_Task_GPT.Level2_Prompt_GPT;

import java.util.Scanner;

public class BattleShips {
    private static final int BOARD_SIZE = 10;
    private static final int SHIP_SIZE = 3;
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public static void main(String[] args) {
        initializeBoard();
        placeShips();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    private static void printBoard() {
        System.out.println("  A B C D E F G H I J");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void placeShips() {
        Scanner scanner = new Scanner(System.in);
        for (int shipNumber = 1; shipNumber <= 3; shipNumber++) {
            System.out.println("Placing Ship " + shipNumber);
            for (int shipPart = 1; shipPart <= SHIP_SIZE; shipPart++) {
                System.out.print("Enter the coordinates for part " + shipPart + " (e.g., A5): ");
                String input = scanner.nextLine().toUpperCase();
                int row = input.charAt(1) - '1';
                int col = input.charAt(0) - 'A';
                board[row][col] = 'S';
            }
            printBoard();
        }
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your shot coordinates (e.g., A5): ");
            String input = scanner.nextLine().toUpperCase();
            int row = input.charAt(1) - '1';
            int col = input.charAt(0) - 'A';

            if (board[row][col] == 'S') {
                System.out.println("Hit!");
                board[row][col] = 'X';
            } else {
                System.out.println("Miss!");
            }

            printBoard();

            // Simulate computer's turn (random shot)
            int computerRow = (int) (Math.random() * BOARD_SIZE);
            int computerCol = (int) (Math.random() * BOARD_SIZE);

            System.out.println("Computer's turn: " + (char) (computerCol + 'A') + (computerRow + 1));

            if (board[computerRow][computerCol] == 'S') {
                System.out.println("Computer hit!");
                board[computerRow][computerCol] = 'X';
            } else {
                System.out.println("Computer missed!");
            }

            printBoard();
        }
    }
}

