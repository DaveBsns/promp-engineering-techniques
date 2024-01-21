class VocabularyTrainer:
    def __init__(self):
        self.vocabulary = {}

    def add_word(self, word, definition):
        self.vocabulary[word] = definition

    def learn_words(self):
        if not self.vocabulary:
            print("No words in the vocabulary. Add words first.")
            return

        print("Welcome to the Vocabulary Trainer!")
        for word, definition in self.vocabulary.items():
            user_input = input(f"What does '{word}' mean? ")
            if user_input.lower() == definition.lower():
                print("Correct!")
            else:
                print(f"Wrong! The correct definition is: {definition}")

    def display_vocabulary(self):
        if not self.vocabulary:
            print("No words in the vocabulary.")
            return

        print("Vocabulary:")
        for word, definition in self.vocabulary.items():
            print(f"{word}: {definition}")


def main():
    trainer = VocabularyTrainer()

    while True:
        print("\n1. Add Word\n2. Learn Vocabulary\n3. Display Vocabulary\n4. Exit")
        choice = input("Enter your choice (1/2/3/4): ")

        if choice == "1":
            word = input("Enter the word: ")
            definition = input(f"Enter the definition of '{word}': ")
            trainer.add_word(word, definition)
            print(f"'{word}' added to the vocabulary.")

        elif choice == "2":
            trainer.learn_words()

        elif choice == "3":
            trainer.display_vocabulary()

        elif choice == "4":
            print("Exiting the Vocabulary Trainer. Goodbye!")
            break

        else:
            print("Invalid choice. Please enter a valid option.")


if __name__ == "__main__":
    main()
