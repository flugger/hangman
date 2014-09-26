package game;

import java.lang.String;import java.lang.System;import java.util.Scanner;

/**
 * Created by Kristine Sundt Lorenzten
 */
public class Hangman {

    public static final String word = "WESTERDALS";
    public static int score, guesses;
    public static final int MAX_GUESSES = 20;
    public static Scanner scanner;

    public static void main(String[] args) {

        score = guesses = 0;
        scanner = new Scanner(System.in);

        printRules();
        playGame();
        gameFinished();

        // Close the scanner when we're done using it
        scanner.close();

    }

    public static void printRules() {

        System.out.println("Welcome to game.Hangman! These are the rules:\n" +
                "You have 20 guesses to guess the word.\n" +
                "The word is " + word.length() + " characters long.\n" +
                "Get " + word.length() + " points before you run out of turns to win!\n" +
                "Don't guess the same word twice!\n\n");
    }

    public static void playGame() {

        for (int i = 0; i < MAX_GUESSES; i++) {

            makeLine();

            char letter = getInput();
            System.out.println("You guessed: " + letter + "\n");

            checkIfLetterCorrect(letter);

            // Stop the game if the player wins
            if (score >= word.length()) {
                break;
            }

            guesses++;

            System.out.println("Number of guesses: " + guesses +
                    "\nScore: " + score + "\n");
        }

    }

    public static char getInput() {

        System.out.println("Please guess a letter (the first letter you write will be used): ");
        String input = scanner.nextLine().toUpperCase();

        // Kan også skrives som
        // String input = scanner.nextLine();
        // input = input.toUpperCase();

        return input.charAt(0);
    }

    public static void checkIfLetterCorrect(char letter) {

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == letter) {
                score++;
            }

        }
    }

    public static void gameFinished() {

        if (score == word.length()) {

            System.out.println("Congratulations! You win!");

        } else {

            System.out.println("Ahh, too bad! Better luck next time!");

        }

        System.out.println("The word was: " + word + "\nThank you for playing!");
    }

    public static void makeLine() {
        System.out.println("-----------------------------------------\n");
    }
}
