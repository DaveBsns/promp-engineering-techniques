#include <iostream>
#include <vector>
#include <algorithm>
#include <random>
#include <ctime>


// Vocabulary structure to store pairs of word and its meaning
struct Vocabulary {
    std::string word;
    std::string meaning;
};

// Function to add a new vocabulary to the trainer
void addVocabulary(std::vector<Vocabulary>& vocabularies) {
    Vocabulary newVocabulary;

    // Get word from user
    std::cout << "Enter the vocabulary word: ";
    std::cin.ignore();
    std::getline(std::cin, newVocabulary.word);

    // Get meaning from user
    std::cout << "Enter the meaning of '" << newVocabulary.word << "': ";
    std::getline(std::cin, newVocabulary.meaning);

    // Add the new vocabulary to the vector
    vocabularies.push_back(newVocabulary);

    std::cout << "Vocabulary added successfully!\n";
}

// Function to start the vocabulary learning session
void startLearning(const std::vector<Vocabulary>& vocabularies) {
    if (vocabularies.empty()) {
        std::cout << "No vocabularies to learn. Please add some vocabularies first.\n";
        return;
    }

    // Set up a random seed for shuffling vocabularies
    std::srand(static_cast<unsigned int>(std::time(0)));

    // Shuffle the vocabularies
    std::vector<Vocabulary> shuffledVocabularies = vocabularies;
    std::random_shuffle(shuffledVocabularies.begin(), shuffledVocabularies.end());




    // Iterate through shuffled vocabularies for learning
    for (const Vocabulary& vocab : shuffledVocabularies) {
        std::string userAnswer;

        // Prompt the user with a vocabulary
        std::cout << "What is the meaning of '" << vocab.word << "'?\n";
        std::getline(std::cin, userAnswer);

        // Check if the answer is correct
        if (userAnswer == vocab.meaning) {
            std::cout << "Correct!\n";
        } else {
            std::cout << "Incorrect. The correct meaning is: " << vocab.meaning << "\n";
        }
    }

    std::cout << "You have completed the learning session!\n";
}

int main() {
    std::vector<Vocabulary> vocabularies;

    int choice;

    do {
        // Display menu
        std::cout << "\nVocabulary Trainer Menu:\n";
        std::cout << "1. Add Vocabulary\n";
        std::cout << "2. Learn Vocabularies\n";
        std::cout << "3. Exit\n";
        std::cout << "Enter your choice (1-3): ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                addVocabulary(vocabularies);
                break;
            case 2:
                startLearning(vocabularies);
                break;
            case 3:
                std::cout << "Exiting the Vocabulary Trainer. Goodbye!\n";
                break;
            default:
                std::cout << "Invalid choice. Please enter a valid option.\n";
        }

    } while (choice != 3);

    return 0;
}
