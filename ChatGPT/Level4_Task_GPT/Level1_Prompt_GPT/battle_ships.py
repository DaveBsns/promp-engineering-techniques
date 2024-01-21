import random

def print_board(board):
    for row in board:
        print(" ".join(row))

def random_row_col(board):
    return random.randint(0, len(board) - 1)

def place_ships(board, num_ships):
    for _ in range(num_ships):
        ship_row = random_row_col(board)
        ship_col = random_row_col(board)

        while board[ship_row][ship_col] == "O":
            ship_row = random_row_col(board)
            ship_col = random_row_col(board)

        board[ship_row][ship_col] = "O"

def is_valid_move(guess_row, guess_col, board):
    return 0 <= guess_row < len(board) and 0 <= guess_col < len(board[0])

def is_ship_sunk(guess_row, guess_col, board):
    return board[guess_row][guess_col] == "O"

def play_battleships(board_size=5, num_ships=3):
    board = [["~" for _ in range(board_size)] for _ in range(board_size)]
    computer_board = [["~" for _ in range(board_size)] for _ in range(board_size)]

    place_ships(computer_board, num_ships)

    print("Welcome to Battleships!")
    print_board(board)

    for turn in range(1, board_size**2 + 1):
        print("\nTurn", turn)

        # Player's move
        guess_row = int(input("Guess Row: ")) - 1
        guess_col = int(input("Guess Col: ")) - 1

        if not is_valid_move(guess_row, guess_col, board):
            print("Invalid move. Try again.")
            continue

        if is_ship_sunk(guess_row, guess_col, board):
            print("You already guessed that. Try again.")
            continue

        if is_ship_sunk(guess_row, guess_col, computer_board):
            print("Congratulations! You sunk the computer's battleship!")
            break
        else:
            print("You missed!")

        board[guess_row][guess_col] = "X"
        print_board(board)

        # Computer's move
        comp_guess_row = random_row_col(board)
        comp_guess_col = random_row_col(board)

        while board[comp_guess_row][comp_guess_col] == "X":
            comp_guess_row = random_row_col(board)
            comp_guess_col = random_row_col(board)

        if is_ship_sunk(comp_guess_row, comp_guess_col, computer_board):
            print("Oh no! The computer sunk your battleship!")
            break
        else:
            print("The computer missed!")

        board[comp_guess_row][comp_guess_col] = "O"
        print_board(board)

    print("\nGame Over!")

if __name__ == "__main__":
    play_battleships()
