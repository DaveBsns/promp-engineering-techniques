def print_board(board):
    for row in board:
        print(' '.join(row))

def place_ships(board):
    # Place the aircraft carrier (5 cells)
    placed = False
    while not placed:
        orientation = input("Enter orientation (h/v): ")
        x = int(input("Enter starting x-coordinate: "))
        y = int(input("Enter starting y-coordinate: "))

        if orientation == 'h':
            if 0 <= x <= 9 and 5 <= x + 4 <= 19:
                for i in range(5):
                    board[y][x + i] = 'A'
                placed = True
            else:
                print("Invalid placement.")
        elif orientation == 'v':
            if 0 <= y <= 9 and 5 <= y + 4 <= 19:
                for i in range(5):
                    board[y + i][x] = 'A'
                placed = True
            else:
                print("Invalid placement.")
    # Place the battleship (4 cells)
    placed = False
    while not placed:
        orientation = input("Enter orientation (h/v): ")
        x = int(input("Enter starting x-coordinate: "))
        y = int(input("Enter starting y-coordinate: "))

        if orientation == 'h':
            if 0 <= x <= 9 and 4 <= x + 3 <= 19:
                for i in range(4):
                    board[y][x + i] = 'B'
                placed = True
            else:
                print("Invalid placement.")
        elif orientation == 'v':
            if 0 <= y <= 9 and 4 <= y + 3 <= 19:
                for i in range(4):
                    board[y + i][x] = 'B'
                placed = True
            else:
                print("Invalid placement.")
    # Place the cruiser (3 cells)
    placed = False
    while not placed:
        orientation = input("Enter orientation (h/v): ")
        x = int(input("Enter starting x-coordinate: "))
        y = int(input("Enter starting y-coordinate: "))

        if orientation == 'h':
            if 0 <= x <= 9 and 3 <= x + 2 <= 19:
                for i in range(3):
                    board[y][x + i] = 'C'
                placed = True
            else:
                print("Invalid placement.")
        elif orientation == 'v':
            if 0 <= y <= 9 and 3 <= y + 2 <= 19:
                for i in range(3):
                    board[y + i][x] = 'C'
                placed = True
            else:
                print("Invalid placement.")
    # Place the destroyer (2 cells)
    placed = False
    while not placed:
        orientation = input("Enter orientation (h/v): ")
        x = int(input("Enter starting x-coordinate: "))
        y = int(input("Enter starting y-coordinate: "))

        if orientation == 'h':
            if 0 <= x <= 9 and 2 <= x + 1 <= 19:
                for i in range(2):
                    board[y][x + i] = 'D'
                placed = True
            else:
                print("Invalid placement.")
        elif orientation == 'v':
            if 0 <= y <= 9 and 2 <= y + 1 <= 19:
                for i in range(2):
                    board[y + i][x] = 'D'
                placed = True
            else:
                print("Invalid placement.")
    # Place the submarine (1 cell)
    placed = False
    while not placed:
        x = int(input("Enter x-coordinate: "))
        y = int(input("Enter y-coordinate: "))

        # test
        if 0 <= x <= 19 and 0 <= y <= 19:
            board[y][x] = 'S'
            placed = True
        else:
            print("Invalid placement.")



ship_types = {
    1: 5,  # Aircraft carrier
    2: 4,  # Battleship
    3: 3,  # Cruiser
    4: 2,  # Destroyer
    5: 1,  # Submarine
}

def check_hit(board, x, y):
    if board[y][x] == 'X' or board[y][x] == 'O':
        return False
    return True

def attack(board, player):
    while True:
        x = int(input(f"{player}'s turn, enter x-coordinate: "))
        y = int(input(f"{player}'s turn, enter y-coordinate: "))

        if not (0 <= x <= 19 and 0 <= y <= 19):
            print("Invalid coordinates.")
            continue

        if board[y][x] == '*':
            print("You already attacked that cell.")
            continue

        hit = check_hit(board, x, y)

        if hit:
            board[y][x] = 'X'
            print(f"{player} hit a ship!")
        else:
            board[y][x] = 'O'
            print(f"{player} missed.")

        return hit

def computer_attack(board):
    while True:
        x = random.randint(0, 19)
        y = random.randint(0, 19)

        if not board[y][x] == '*':
            break

    hit = check_hit(board, x, y)

    if hit:
        board[y][x] = 'X'
        print("Computer hit a ship!")
    else:
        board[y][x] = 'O'
        print("Computer missed.")

    return hit

def main():
    board = [['*' for _ in range(20)] for _ in range(20)]

    # Place the player's ships
    place_ships(board)

    # Game loop
    player = 'Player'
    while True:
        print_board(board)

        hit = attack(board, player)

        if all(ship == '*' for ship in ship_types.values()):
            print(f"{player} wins!")
            break

        player = 'Computer' if player == 'Player' else 'Player'

        if not hit:
            print("All ships sunk.")
            break

        computer_attack(board)

main()
