/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rock_paper_scisors.java;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


/**
 *
 * @author IT Student
 */
public class Rock_paper_scisorsJava {

    // Integer showing how many games the player has won
    private static int gamesWon = 0;

    // Integer showing how many games the player has won
    private static int gamesLost = 0;

    // Integer showing how many games the player has won
    private static int gamesTied = 0;

    // Integer showing how many games have been played
    private static int gameCount = 1;

    // The scanner for pulling user input
    private static Scanner scanner = new Scanner (System.in);

    // The generator for pulling random numbers
    private static Random random = new Random();

    // The list of choices that the player can make
    // Index 0, 1, and 2 should always be 
    // Rock, Paper, Scissors respectively
    private static String[] playerChoices = {"Rock", "Paper", "Scissors", "Exit"};
    
    public static void main(String[] args) {
        while (true) {

            System.out.println("--------------------");

            System.out.println(
                String.format("Game %d (W: %d, L: %d, T: %d)", gameCount, gamesWon, gamesLost, gamesTied)
            );

            System.out.println ("Enter your Choice:");
            
            String userChoice = printUserChoices();

            int userChoiceIndex = TryGetIndexOfUserChoice(userChoice);

            // Invalid Choice is always -1
            boolean choiceIsInvalid = userChoiceIndex == -1;

            if (choiceIsInvalid) {

                System.out.println("Invalid User Choice. Try Again");

            } else {

                if (playerChoices[userChoiceIndex] == "Exit") {

                    break;

                }

                playGame(userChoiceIndex);

            }
        }

        scanner.close();

    }

    // Simulate a game of Rock Paper Scissors
    private static void playGame(int userChoiceIndex) {
                
        // generate a random number between 0 and 2 (Rock = 0, Paper = 1, Scissors = 2)
        int computerChoice = random.nextInt(3);


        System.out.println(
            String.format("You chose %s", playerChoices[userChoiceIndex])
        );

        System.out.println(
            String.format("Computer chose %s", playerChoices[computerChoice])
        );

        // 0 = Tie, 1 = Player Win, 2 = Computer Win
        int outcome = (userChoiceIndex - computerChoice + 3) % 3;

        // Tie
        if (outcome == 0) {

            System.out.println("The game was a tie!");

            gamesTied++;

        // Player Win
        } else if (outcome == 1) {

            System.out.println("You won!");

            gamesWon++;

        // Computer Win
        } else if (outcome == 2) {

            System.out.println("The computer won!");
            
            gamesLost++;

        }

        gameCount++; 

    }

    // Return the index of the user input from the playerChoices list
    // If the index is not found, return -1
    private static int TryGetIndexOfUserChoice(String userChoice) {
        try {

            // Check if the user input is an int
            int userChoiceNumber = Integer.parseInt(userChoice);

            // Check the number chosen was valid
            if (userChoiceNumber < playerChoices.length) {

                return userChoiceNumber;

            } 

            return -1;

        } catch (NumberFormatException e) {

            String userChoiceCapitalised = Capitalize(userChoice);

            // Rock, Paper, Scissors, Exit, 1, 2, 3, 4
            // rock, ROCK
            // If the user input is in the playerChoices list, return the index
            int index = Arrays.asList(playerChoices).indexOf(userChoiceCapitalised);

            // Binary search 
            if (index < 0) {

                return -1;

            }

            return index;

        }

    }

    // Given any string, return the same string in Capitalised form
    private static String Capitalize(String word) {
        return Character.toUpperCase(word.charAt(0))+word.toLowerCase().substring(1);
    }

    // Handler function to print the user choices to the screen
    private static String printUserChoices() {

        // Loop through all playerChoices
        for (int i = 0; i < playerChoices.length; i++) {

            //Print out a list of player choices
            System.out.println(
                String.format("%d: %s",i, playerChoices[i])
            );
        } 
        
        // Take User Input
        String userChoice = scanner.next();

        return userChoice;
    }
    
}
