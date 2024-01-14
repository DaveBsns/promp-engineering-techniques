## Documentation Snake game with GUI - Level 2 Prompt - Bard

1. **Initial Setup:**
    - The game starts with a small snake (initially 3 segments) positioned at the center of the game window.
    - A "gem" is randomly generated within the game window.
2. **User Input:**
    - The player controls the snake's movement using the keyboard keys W, A, S, and D.
        - W: moves the snake upwards
        - A: moves the snake left
        - S: moves the snake downwards
        - D: moves the snake right
3. **Snake Movement:**
    - The snake continuously moves in the direction specified by the player's input.
    - The head of the snake is always the first segment, and the tail of the snake is the last segment.
4. **Snake Growth:**
    - When the snake collides with a "gem", the snake grows by one segment, and a new "gem" is randomly generated.
5. **Game Over:**
    - The game ends if the snake collides with its own body or the edge of the game window.
6. **Highscore:**
    - The highscore is maintained, and it increases with each "gem" collected.
    
    **Control Keys:**
    
    - W: Up
    - A: Left
    - S: Down
    - D: Right
    
    **Setup, Compilation, and Execution in Visual Studio Code**
    
7. **Install Dependencies:**
    - Install the following libraries using Visual Studio Code's package manager:
        - SFML (Simple and Fast Multimedia Library): For graphics rendering and event handling.
8. **Create Project Structure:**
    - Create a new directory for your project.
    - Inside the directory, create two files:
        - `main.cpp`: The main source file containing the game logic and rendering code.
        - `config.h`: A header file to store game constants and configurations.
9. **Implement Game Logic:**
    - In `main.cpp`, include the necessary headers for SFML and your own custom headers.
    - Initialize SFML and create a rendering window.
    - Implement the main game loop:
        - Handle user input and update the snake's direction accordingly.
        - Check for collisions and end the game if necessary.
        - Update the snake's position and render it on the screen.
        - Generate a "gem" at random intervals and check for collisions with the snake.
        - Update the highscore if the snake grows.
        - Sleep for a brief interval to control the game's speed.
    - Destroy the rendering window and terminate SFML.
10. **Compile and Execute:**
    - Save the source files (main.cpp and config.h).
    - Open the project in Visual Studio Code.
    - Open the terminal and navigate to the project directory.
    - Run the following command to compile the source code:
        - `g++ main.cpp -o snakeGame -lsfml-graphics -lsfml-window -lsfml-system`
    - Run the compiled executable using the following command:
        - `./snakeGame`

**Additional Notes:**

- Adjust the game's speed by changing the sleep interval in the main loop.
- Enhance the game's appearance by using different colors for the snake, "gem", and background.
- Implement multiple levels or difficulty settings with varying speed and "gem" generation rates.
- Add sound effects for collisions, gem collection, and game over.