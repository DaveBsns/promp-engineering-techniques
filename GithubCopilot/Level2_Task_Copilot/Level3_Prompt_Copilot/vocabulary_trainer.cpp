#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <random>

struct Vocabulary {
    std::string word;
    std::string meaning;
};

std::vector<Vocabulary> vocabularies;

void addVocabulary() {
    std::string word, meaning;
    std::cout << "Enter the vocabulary: ";
    std::getline(std::cin >> std::ws, word);
    std::cout << "Enter the meaning: ";
    std::getline(std::cin >> std::ws, meaning);

    vocabularies.push_back({word, meaning});
    std::cout << "Vocabulary added successfully!\n";
}

void learnVocabularies() {
    if (vocabularies.empty()) {
        std::cout << "No vocabularies to learn.\n";
        return;
    }

    std::random_device rd;
    std::mt19937 g(rd());
    std::shuffle(vocabularies.begin(), vocabularies.end(), g);

    for (const auto& vocabulary : vocabularies) {
        std::string userAnswer;
        std::cout << "Vocabulary: " << vocabulary.word << "\n";
        std::cout << "Enter the meaning: ";
        std::getline(std::cin >> std::ws, userAnswer);

        std::transform(userAnswer.begin(), userAnswer.end(), userAnswer.begin(), ::tolower);
        std::string mutableMeaning = vocabulary.meaning; // Create a mutable copy of the meaning
        std::transform(mutableMeaning.begin(), mutableMeaning.end(), mutableMeaning.begin(), ::tolower);

        if (userAnswer == mutableMeaning) {
            std::cout << "Correct!\n";
        } else {
            std::cout << "Wrong! The correct meaning is: " << vocabulary.meaning << "\n";
        }
    }
}

int main() {
    int choice;
    do {
        std::cout << "Menu:\n";
        std::cout << "1. Add a new vocabulary\n";
        std::cout << "2. Learn vocabularies\n";
        std::cout << "3. Exit\n";
        std::cout << "Enter your choice: ";
        std::cin >> choice;
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

        switch (choice) {
            case 1:
                addVocabulary();
                break;
            case 2:
                learnVocabularies();
                break;
            case 3:
                std::cout << "Exiting...\n";
                break;
            default:
                std::cout << "Invalid choice. Please try again.\n";
                break;
        }
    } while (choice != 3);

    return 0;
}
