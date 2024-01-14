## Documentation Battleships against the computer - Level 4 Prompt - Bard

**Battleships: A Beginner's Guide**

**Welcome to the captivating world of Battleships!**

Prepare to engage in a strategic duel of naval warfare against the computer. Your mission: sink all enemy ships before they sink yours.

**Getting Started**

1. **Download and Install Visual Studio Code:** Visual Studio Code is a free and open-source code editor that allows you to run and debug the Battleships game. You can download it from the official website: https://code.visualstudio.com/
2. **Clone the Battleships Repository:** Open a terminal window and navigate to the directory where you want to store the Battleships code. Then, run the following command to clone the repository from GitHub:

`git clone https://github.com/bard/battleships-gui.git`

1. **Open the Battleships Project in Visual Studio Code:** Open Visual Studio Code and click on "File" > "Open Folder". Select the cloned Battleships directory and click "Open".
2. **Install the Required Packages:** The Battleships game utilizes Java and JavaFX for its GUI. To install these packages, follow these steps:
    
    a. Open the Command Palette in Visual Studio Code (Ctrl+Shift+P or Cmd+Shift+P).
    
    b. Type "Java SDK" and select "Install Java SDK" from the list of options.
    
    c. Choose the appropriate Java SDK version and click "Install".
    
3. **Set Up the Project:** To run the Battleships game, you need to set up the project environment:
    
    a. In the Project view (the left panel in Visual Studio Code), right-click on the "src" folder and select "Mark Directory as" > "Sources Root".
    
    b. Open the "launch.json" file located in the ".vscode" folder.
    
    c. Modify the "program" field to point to the main class of the Battleships game, which is "BattleshipsGUI".
    

**Understanding the Gameplay**

The Battleships game is played on a 10x10 grid, where you and the computer place your ships and take turns aiming at each other's ships.

**Objective:**

Your goal is to sink all of the enemy ships before they sink yours. A ship is considered sunk when all of its squares have been hit.

**Gameplay Mechanics:**

1. **Ship Placement:**
    - At the beginning of the game, you and the computer will place three ships each.
    - You can place your ships horizontally or vertically.
    - Each ship must be placed on adjacent squares.
    - You cannot place ships on squares that already have ships.
2. **Taking Turns:**
    - On your turn, you will choose a square on the enemy grid to attack.
    - The computer will also take a turn attacking your grid.
3. **Hit or Miss:**
    - If you hit an enemy ship, a red mark will appear on the corresponding square of the enemy grid.
    - If you miss, a green mark will appear on the corresponding square of your grid.
4. **Sinking a Ship:**
    - When all of the squares of a ship have been hit, the ship is considered sunk.
    - A sunk ship will be marked with a red "X" on the corresponding squares of both grids.

**Winning the Game:**

The game ends when one player sinks all of the opponent's ships. The player who sinks all of the enemy ships first wins the game!