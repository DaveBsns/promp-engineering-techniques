import pygame

# Initialize pygame
pygame.init()

# Set up the display
width = 800
height = 600
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Snake")

# Define colors
black = (0, 0, 0)
white = (255, 255, 255)
red = (255, 0, 0)
green = (0, 255, 0)
blue = (0, 0, 255)

# Define snake properties
snake_pos = [100, 50]  # Initial position of the snake head
snake_body = [[100, 50], [90, 50], [80, 50]]  # List of snake body positions
snake_direction = 'up'  # Initial direction of the snake

# Define food position
food_pos = [300, 300]  # Initial position of the food

# Game loop
running = True
while running:
    # Check for events
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

        # Handle snake movement
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP and snake_direction != 'down':
                snake_direction = 'up'
            elif event.key == pygame.K_DOWN and snake_direction != 'up':
                snake_direction = 'down'
            elif event.key == pygame.K_LEFT and snake_direction != 'right':
                snake_direction = 'left'
            elif event.key == pygame.K_RIGHT and snake_direction != 'left':
                snake_direction = 'right'

    # Update snake position
    if snake_direction == 'up':
        snake_pos[1] -= 10
    elif snake_direction == 'down':
        snake_pos[1] += 10
    elif snake_direction == 'left':
        snake_pos[0] -= 10
    elif snake_direction == 'right':
        snake_pos[0] += 10

    # Check for collision with food
    if snake_pos == food_pos:
        # Grow the snake
        snake_body.append([snake_pos[0], snake_pos[1]])

        # Generate new food position
        while True:
            new_food_pos = [random.randint(10, width - 10), random.randint(10, height - 10)]
            if new_food_pos not in snake_body:
                food_pos = new_food_pos
                break

    # Check for collision with wall
    if snake_pos[0] < 0 or snake_pos[0] >= width or snake_pos[1] < 0 or snake_pos[1] >= height:
        running = False

    # Check for collision with itself
    for body_part in snake_body[:-1]:
        if snake_pos == body_part:
            running = False

    # Update snake body positions
    snake_body.insert(0, list(snake_pos))
    del snake_body[-1]

    # Fill the screen with black
    screen.fill(black)

    # Draw the snake
    for pos in snake_body:
        pygame.draw.rect(screen, green, pygame.Rect(pos[0], pos[1], 10, 10))

    # Draw the food
    pygame.draw.rect(screen, red, pygame.Rect(food_pos[0], food_pos[1], 10, 10))

    # Update the display
    pygame.display.flip()

# Quit pygame
pygame.quit()
