class VocabularyTrainer:
    def __init__(self):
        self.vocabulary = {}

    def add_word(self, word, meaning):
        self.vocabulary[word] = meaning

    def edit_word(self, word, new_meaning):
        if word in self.vocabulary:
            self.vocabulary[word] = new_meaning
        else:
            print("Word not found in vocabulary.")

    def delete_word(self, word):
        if word in self.vocabulary:
            del self.vocabulary[word]
        else:
            print("Word not found in vocabulary.")

    def learn(self):
        for word, meaning in self.vocabulary.items():
            print(f"Word: {word}, Meaning: {meaning}")


# Usage
trainer = VocabularyTrainer()
trainer.add_word("Python", "A high-level general-purpose programming language.")
trainer.edit_word("Python", "A popular high-level general-purpose programming language.")
trainer.learn()
trainer.delete_word("Python")