import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int score = 0;
        int rounds = 3;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= rounds; round++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("I have generated a number between " + min + " and " + max + ". Can you guess it?");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    hasWon = true;
                    score += (maxAttempts - attempts + 1) * 10; // More points for fewer attempts
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry! You've used all attempts. The number was: " + randomNumber);
            }
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}