import random
import sys
from termcolor import colored
import nltk

# Download the required NLTK data
nltk.download('words')
from nltk.corpus import words

# Constants
ATTEMPTS_ALLOWED = 6

# Function to print the game menu
def print_menu():
    print("Welcome to the Wordle Game")
    print("Enter a word to guess the word.")
    print(f"You have {ATTEMPTS_ALLOWED} chances to guess the word.\n")

# Function to read a random word from the word list
def read_random_word(word_length):
    word_list = [word.lower() for word in words.words() if len(word) == word_length]
    return random.choice(word_list)

# Function to get user input and validate it
def get_valid_guess(word_length):
    while True:
        guess = input(f"Enter a {word_length} letter word: ").lower()
        if len(guess) == word_length and guess.isalpha():
            return guess
        print(colored(f"Invalid input! Please enter a {word_length} letter word.", "red"))

# Function to play the game
def play_game(word_length):
    random_word = read_random_word(word_length)
    attempts = 0
    guesses = []

    while attempts < ATTEMPTS_ALLOWED:
        print(f"\nAttempt {attempts + 1}")
        guess = get_valid_guess(word_length)
        guesses.append(guess)

        for i in range(word_length):
            if guess[i] == random_word[i]:
                print(colored(guess[i], "green"), end="")
            elif guess[i] in random_word:
                print(colored(guess[i], "yellow"), end="")
            else:
                print(colored(guess[i], "red"), end="")

        if guess == random_word:
            print(colored(f"\nCongratulations! You have guessed the word correctly in {attempts + 1} attempts.", "green"))
            return

        attempts += 1

    print(colored(f"\nSorry! You have used all your attempts. The word was {random_word}.", "red"))
    print(colored(f"Your guesses: {', '.join(guesses)}", "yellow"))

# Function to choose the difficulty level
def choose_difficulty_level():
    while True:
        level = input("Choose difficulty level (easy, medium, hard): ").lower()
        if level == "easy":
            return 4
        elif level == "medium":
            return 5
        elif level == "hard":
            return 6
        print(colored("Invalid input! Please choose 'easy', 'medium', or 'hard'.", "red"))

# Main game loop
def main():
    print_menu()
    word_length = choose_difficulty_level()

    while True:
        play_game(word_length)
        play_again = input("Do you want to play again? (y/n): ").lower()
        if play_again != "y":
            print(colored("Thanks for playing! Goodbye!", "green"))
            break

if __name__ == "__main__":
    main()