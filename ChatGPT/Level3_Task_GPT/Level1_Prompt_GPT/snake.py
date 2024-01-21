import tkinter as tk
import random

class SnakeGame:
    def __init__(self, master):
        self.master = master
        self.master.title("Snake Game")
        self.canvas = tk.Canvas(master, width=400, height=400, bg="black")
        self.canvas.pack()

        self.snake = [(100, 100), (90, 100), (80, 100)]
        self.direction = "Right"
        self.food = self.create_food()
        self.speed = 100  # Adjust speed as needed

        self.master.bind("<KeyPress>", self.on_key_press)
        self.update()

    def create_food(self):
        x = random.randint(0, 39) * 10
        y = random.randint(0, 39) * 10
        self.canvas.create_rectangle(x, y, x + 10, y + 10, fill="red", tags="food")
        return x, y

    def move(self):
        head = self.snake[0]
        if self.direction == "Up":
            new_head = (head[0], head[1] - 10)
        elif self.direction == "Down":
            new_head = (head[0], head[1] + 10)
        elif self.direction == "Left":
            new_head = (head[0] - 10, head[1])
        elif self.direction == "Right":
            new_head = (head[0] + 10, head[1])

        self.snake.insert(0, new_head)

        if new_head == self.food:
            self.canvas.delete("food")
            self.food = self.create_food()
        else:
            tail = self.snake.pop()
            self.canvas.delete(tail)

        self.check_collision()

        for segment in self.snake:
            self.canvas.create_rectangle(segment[0], segment[1], segment[0] + 10, segment[1] + 10, fill="green")

    def check_collision(self):
        head = self.snake[0]
        if head[0] < 0 or head[0] >= 400 or head[1] < 0 or head[1] >= 400 or head in self.snake[1:]:
            self.game_over()

    def game_over(self):
        self.canvas.create_text(200, 200, text="Game Over", fill="white", font=("Helvetica", 16), tags="game_over")
        self.master.after_cancel(self.after_id)

    def on_key_press(self, event):
        key = event.keysym
        if key == "Up" and self.direction != "Down":
            self.direction = "Up"
        elif key == "Down" and self.direction != "Up":
            self.direction = "Down"
        elif key == "Left" and self.direction != "Right":
            self.direction = "Left"
        elif key == "Right" and self.direction != "Left":
            self.direction = "Right"

    def update(self):
        self.move()
        self.after_id = self.master.after(self.speed, self.update)

# Main function
def main():
    root = tk.Tk()
    snake_game = SnakeGame(root)
    root.mainloop()

if __name__ == "__main__":
    main()
