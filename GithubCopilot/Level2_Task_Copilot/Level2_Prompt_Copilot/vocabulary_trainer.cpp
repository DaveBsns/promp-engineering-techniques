#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <ctime>

// Function to add a new vocabulary
void addVocabulary(std::vector<std::pair<std::string, std::string>>& vocabularies) {
    std::string vocabulary, meaning;
    
    std::cout << "Enter the vocabulary: ";
    std::getline(std::cin, vocabulary);
    
    std::cout << "Enter the meaning: ";
    std::getline(std::cin, meaning);
    
    vocabularies.push_back(std::make_pair(vocabulary, meaning));
    
    std::cout << "Vocabulary added successfully!\n";
}

// Function to learn vocabularies
void learnVocabularies(const std::vector<std::pair<std::string, std::string>>& vocabularies) {
    if (vocabularies.empty()) {
        std::cout << "No vocabularies found!\n";
        return;
    }
    
    std::srand(std::time(0));
    
    std::cout << "Learning mode:\n";
    
    while (true) {
        int index = std::rand() % vocabularies.size();
        
        std::cout << "Vocabulary: " << vocabularies[index].first << "\n";
        std::cout << "Enter the meaning: ";
        
        std::string meaning;
        std::getline(std::cin, meaning);
        
        if (meaning == vocabularies[index].second) {
            std::cout << "Correct!\n";
        } else {
            std::cout << "Incorrect! The correct meaning is: " << vocabularies[index].second << "\n";
        }
        
        std::cout << "Press enter to continue or 'q' to quit learning mode: ";
        std::string choice;
        std::getline(std::cin, choice);
        
        if (choice == "q") {
            break;
        }
    }
}

int main() {
    std::vector<std::pair<std::string, std::string>> vocabularies;
    
    while (true) {
        std::cout << "Select an option:\n";
        std::cout << "1. Add a new vocabulary\n";
        std::cout << "2. Learn vocabularies\n";
        std::cout << "3. Quit\n";
        
        std::string choice;
        std::getline(std::cin, choice);
        
        if (choice == "1") {
            addVocabulary(vocabularies);
        } else if (choice == "2") {
            learnVocabularies(vocabularies);
        } else if (choice == "3") {
            break;
        } else {
            std::cout << "Invalid option! Please try again.\n";
        }
    }
    
    return 0;
}
