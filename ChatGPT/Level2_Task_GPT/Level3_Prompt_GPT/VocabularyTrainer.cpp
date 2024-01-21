#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>
#include <cstdlib>

// Structure to represent a vocabulary entry
struct Vocabulary {
    std::string word;
    std::string meaning;
};

// Function to add a new vocabulary entry
void addVocabulary(std::vector<Vocabulary>& vocabularies) {
    Vocabulary newVocabulary;
    
    // Get user input for the new vocabulary
    std::cout << "Enter a new vocabulary (word or sentence): ";
    std::getline(std::cin, newVocabulary.word);
    
    // Get user input for the meaning of the vocabulary
    std::cout << "Enter the meaning of the vocabulary: ";
    std::getline(std::cin, newVocabulary.meaning);

    // Store the new vocabulary entry
    vocabularies.push_back(newVocabulary);
}

// Function to learn vocabularies
void learnVocabularies(const std::vector<Vocabulary>& vocabularies) {
    // Randomize the order of vocabularies
    std::vector<Vocabulary> randomizedVocabularies = vocabularies;
    std::random_shuffle(randomizedVocabularies.begin(), randomizedVocabularies.end());

    // Iterate through randomized vocabularies
    for (const Vocabulary& vocabulary : randomizedVocabularies) {
        std::string userAnswer;

        // Prompt user for the meaning of the vocabulary
        std::cout << "What is the meaning of: " << vocabulary.word << "? ";
        std::getline(std::cin, userAnswer);

        // Convert user's answer and correct meaning to lowercase for case-insensitive comparison
        std::transform(userAnswer.begin(), userAnswer.end(), userAnswer.begin(), ::tolower);
        std::string correctMeaningLower = vocabulary.meaning;
        std::transform(correctMeaningLower.begin(), correctMeaningLower.end(), correctMeaningLower.begin(), ::tolower);

        // Check if the user's answer is correct
        if (userAnswer == correctMeaningLower) {
            std::cout << "Correct!\n";
        } else {
            std::cout << "Wrong! The correct meaning is: " << vocabulary.meaning << "\n";
        }
    }
}

int main() {
    // Seed for randomization
    std::srand(static_cast<unsigned int>(std::time(nullptr)));

    std::vector<Vocabulary> vocabularies; // Vector to store vocabularies

    int choice;
    do {
        // Display menu
        std::cout << "Menu:\n";
        std::cout << "1. Add a new vocabulary\n";
        std::cout << "2. Learn vocabularies\n";
        std::cout << "3. Exit\n";
        std::cout << "Enter your choice (1-3): ";
        std::cin >> choice;
        std::cin.ignore(); // Clear the newline character from the buffer

        switch (choice) {
            case 1:
                addVocabulary(vocabularies);
                break;
            case 2:
                if (vocabularies.empty()) {
                    std::cout << "No vocabularies to learn. Add some vocabularies first.\n";
                } else {
                    learnVocabularies(vocabularies);
                }
                break;
            case 3:
                std::cout << "Exiting the program. Goodbye!\n";
                break;
            default:
                std::cout << "Invalid choice. Please enter a number between 1 and 3.\n";
                break;
        }
    } while (choice != 3);

    return 0;
}
