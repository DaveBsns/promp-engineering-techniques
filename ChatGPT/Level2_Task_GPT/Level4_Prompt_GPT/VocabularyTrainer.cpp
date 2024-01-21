#include <iostream>
#include <unordered_map>
#include <cstdlib>  // For rand() and srand()
#include <ctime>    // For time()
#include <algorithm> // For case-insensitive comparison

// Function to add a new vocabulary to the map
void addVocabulary(std::unordered_map<std::string, std::string>& vocabularyMap) {
    // Prompt user to insert vocabulary
    std::cout << "Enter a vocabulary (word or sentence): ";
    std::string vocabulary;
    std::getline(std::cin, vocabulary);

    // Prompt user to insert the meaning of the vocabulary
    std::cout << "Enter the meaning of the vocabulary: ";
    std::string meaning;
    std::getline(std::cin, meaning);

    // Store the vocabulary and its meaning in the map
    vocabularyMap[vocabulary] = meaning;

    std::cout << "\nVocabulary added successfully!\n\n";
}

// Function to conduct a learning session with stored vocabularies
void learnVocabularies(std::unordered_map<std::string, std::string>& vocabularyMap) {
    if (vocabularyMap.empty()) {
        std::cout << "No vocabularies available for learning. Add some vocabularies first.\n\n";
        return;
    }

    // Seed for randomization
    std::srand(std::time(0));

    // Iterate through all stored vocabularies
    for (const auto& pair : vocabularyMap) {
        // Display the vocabulary
        std::cout << "Vocabulary: " << pair.first << "\n";

        // Prompt user to input the meaning
        std::cout << "Enter the meaning of the vocabulary: ";
        std::string userMeaning;
        std::getline(std::cin, userMeaning);

        // Convert both the stored meaning and user input to lowercase for case-insensitive comparison
        std::string storedMeaningLower = pair.second;
        std::transform(storedMeaningLower.begin(), storedMeaningLower.end(), storedMeaningLower.begin(), ::tolower);
        std::transform(userMeaning.begin(), userMeaning.end(), userMeaning.begin(), ::tolower);

        // Check if the user's input matches the stored meaning
        if (userMeaning == storedMeaningLower) {
            std::cout << "Correct!\n\n";
        } else {
            std::cout << "Wrong! The correct meaning is: " << pair.second << "\n\n";
        }
    }

    std::cout << "Learning session complete!\n\n";
}

// Main function
int main() {
    std::unordered_map<std::string, std::string> vocabularyMap;

    int choice;
    bool learned = false;

    do {
        // Display menu
        std::cout << "Menu:\n";
        std::cout << "1. Add new vocabulary\n";
        std::cout << "2. Learn vocabularies\n";
        std::cout << "3. Exit\n";

        if (!learned) {
            std::cout << "Note: Complete learning session (option 2) before choosing other options.\n";
        }

        std::cout << "Enter your choice (1-3): ";

        // Get user choice
        std::cin >> choice;
        std::cin.ignore();  // Ignore the newline character in the input buffer

        // Perform actions based on user choice
        switch (choice) {
            case 1:
                addVocabulary(vocabularyMap);
                break;
            case 2:
                learnVocabularies(vocabularyMap);
                learned = true;
                break;
            case 3:
                std::cout << "Exiting the Vocabulary Trainer. Goodbye!\n";
                break;
            default:
                std::cout << "Invalid choice. Please enter a number between 1 and 3.\n\n";
        }

    } while (choice != 3);

    return 0;
}
