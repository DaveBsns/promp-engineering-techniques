## Documentation Battleships against the computer - Level 3 Prompt - Bard

**Game Overview**

Welcome to the classic battleship game! In this two-player challenge, you'll take turns trying to sink your opponent's ships by guessing their locations on a 10x10 grid. Each player has three ships, each consisting of three adjacent squares. The goal is to sink all of your opponent's ships before they sink yours.

**Gameplay**

1. **Ship Placement:**
    - Each player starts with three ships.
    - Position your ships strategically on the grid, ensuring they don't overlap.
    - Mark your ships on a separate paper or digital board, keeping them hidden from your opponent.
    - The computer will automatically place its ships randomly.
2. **Turn-Based Shots:**
    - Take turns guessing the coordinates of your opponent's ships.
    - Click on a grid square to select your target.
    - If you hit a ship, the opponent's grid will display a red mark at the hit location.
    - If you miss, the opponent's grid will display a white mark at the missed location.
    - The computer will automatically take its turns, aiming at your ships.
3. **Sunk Ships:**
    - A ship is sunk when all three of its squares are hit.
    - The player whose ship is sunk marks the squares as red to indicate the sinking.
    - The computer automatically marks its own sunk ships red.
4. **Victory:**
    - The first player to sink all of their opponent's ships wins the game.
    - The game ends when all ships have been sunk or if a player runs out of guesses.

**Technical Implementation**

The game will be developed using Java and the Java Swing framework, creating a graphical user interface (GUI) for the game. The game will utilize a 10x10 matrix to represent the game area, with each square representing a potential location for a ship or a shot.

**User Input:**

- Ship Placement:
    - User input for ship placement will involve entering coordinates and selecting the orientation (vertical or horizontal).
    - The GUI will display input fields for coordinates and orientation options.
- Shooting:
    - User input for shooting will involve clicking on a desired grid square.
    - The GUI will display the grid with clickable squares.

**Game Logic:**

- Ship Placement:
    - The code will validate ship placement to ensure no overlapping ships.
    - The GUI will display error messages if invalid ship placements are attempted.
- Shot Verification:
    - The code will check whether a shot hits a ship or misses.
    - The GUI will display appropriate feedback (green for hits, white for misses).
- Ship Sinking:
    - The code will check if a hit marks the sinking of a ship.
    - The GUI will mark sunk ship squares red.
- Computer AI:**
    - The computer will take its turns automatically, shooting at random locations.
    - The code will implement a random number generator to determine shot coordinates.

**Additional Features:**

- Graphical Representation:
    - The GUI will display a graphical representation of the game state, highlighting ships and hits.
    - The GUI will use different colors to represent different states (ships, hits, misses).

**Documentation:**

- Detailed Instructions:
    - A comprehensive documentation will provide detailed instructions for user input and interaction during the game.
    - The documentation will include step-by-step guidance on ship placement and gameplay.
- Setup and Execution:
    - The documentation will provide clear instructions on how to start, implement, and compile the application in Visual Studio Code.
    - The documentation will explain the project structure and provide step-by-step guides for each step.

**Key Features and Objectives:**

- The game will provide an engaging two-player experience based on the classic battleship game.
- The GUI will enhance gameplay with a visual representation of the game state.
- The user-friendly interface will make it easy to learn and play the game.
- The game will offer strategic challenges and a satisfying sense of accomplishment upon victory.