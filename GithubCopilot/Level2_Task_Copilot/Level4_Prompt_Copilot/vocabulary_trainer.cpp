#include <iostream>
#include <string>
#include <unordered_map>
#include <cstdlib>
#include <algorithm>
#include <ctime>

void addVocabulary(std::unordered_map<std::string, std::string>& vocabularyMap) {
    std::cout << "Enter a vocabulary: ";
    std::string vocabulary;
    std::getline(std::cin, vocabulary);

    std::cout << "Enter the meaning of the vocabulary: ";
    std::string meaning;
    std::getline(std::cin, meaning);

    vocabularyMap[vocabulary] = meaning;
}

void learnVocabularies(const std::unordered_map<std::string, std::string>& vocabularyMap) {
    if (vocabularyMap.empty()) {
        std::cout << "No vocabularies stored." << std::endl;
        return;
    }

    std::srand(std::time(nullptr));
    int randomIndex = std::rand() % vocabularyMap.size();
    auto it = vocabularyMap.begin();
    std::advance(it, randomIndex);

    std::cout << "Vocabulary: " << it->first << std::endl;
    std::cout << "Meaning: " << it->second << std::endl;
}

int main() {
    std::unordered_map<std::string, std::string> vocabularyMap;

    while (true) {
        std::cout << "Menu:" << std::endl;
        std::cout << "1. Add a new vocabulary" << std::endl;
        std::cout << "2. Learn vocabularies" << std::endl;
        std::cout << "3. Exit" << std::endl;

        int choice;
        std::cout << "Enter your choice: ";
        std::cin >> choice;
        std::cin.ignore();

        switch (choice) {
            case 1:
                addVocabulary(vocabularyMap);
                break;
            case 2:
                learnVocabularies(vocabularyMap);
                break;
            case 3:
                return 0;
            default:
                std::cout << "Invalid choice. Please try again." << std::endl;
        }
    }

    return 0;
}

