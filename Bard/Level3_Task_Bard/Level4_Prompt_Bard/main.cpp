#include <SFML/Graphics.hpp>
#include <iostream>

using namespace sf;
using namespace std;

class Snake {
public:
    Snake(int x, int y) {
        head.setPosition(x, y);
        head.setFillColor(Color::Green);

        body.push_back(head);
    }

    void update() {
        int newX = head.getPosition().x;
        int newY = head.getPosition().y;

        switch (direction) {
            case Direction::Up:
                newY--;
                break;
            case Direction::Down:
                newY++;
                break;
            case Direction::Left:
                newX--;
                break;
            case Direction::Right:
                newX++;
                break;
        }

        if (newX < 0 || newX >= windowWidth || newY < 0 || newY >= windowHeight) {
            gameOver = true;
            return;
        }

        for (auto& part : body) {
            if (part.getPosition().x == newX && part.getPosition().y == newY) {
                gameOver = true;
                return;
            }
        }

        head.setPosition(newX, newY);

        if (newX == food.x && newY == food.y) {
            body.push_back(body.back());
            food.setPosition(rand() % windowWidth, rand() % windowHeight);
        } else {
            body.pop_front();
        }
    }

    void draw(RenderWindow* window) {
        window->draw(head);

        for (auto& part : body) {
            window->draw(part);
        }

        window->draw(food);
    }

    bool isGameOver() {
        return gameOver;
    }

private:
    RectangleShape head;
    vector<RectangleShape> body;
    Direction direction = Direction::Right;
    bool gameOver = false;

    int windowWidth = 800;
    int windowHeight = 600;

    enum Direction {
        Up,
        Down,
        Left,
        Right
    };
};

int main() {
    sf::RenderWindow window(sf::VideoMode(windowWidth, windowHeight), "Snake");
    window.setFramerateLimit(60);

    Snake snake(windowWidth / 2, windowHeight / 2);

    RectangleShape food;
    food.setSize(Vector2f(10, 10));
    food.setFillColor(Color::Red);
    food.setPosition(rand() % windowWidth, rand() % windowHeight);

    while (window.isOpen()) {
        Event event;
        while (window.pollEvent(event)) {
            if (event.type == Event::Closed) {
                window.close();
            }

            if (Keyboard::isKeyPressed(Keyboard::W)) {
                snake.direction = Direction::Up;
            } else if (Keyboard::isKeyPressed(Keyboard::S)) {
                snake.direction = Direction::Down;
            } else if (Keyboard::isKeyPressed(Keyboard::A)) {
                snake.direction = Direction::Left;
            } else if (Keyboard::isKeyPressed(Keyboard::D)) {
                snake.direction = Direction::Right;
            }
        }

        if (!snake.isGameOver()) {
            snake.update();
        }

        window.clear();
        snake.draw(&window);
        window.draw(food);
        window.display();
    }

    return 0;
}
