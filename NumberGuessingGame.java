import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundNumber = 1;

        while (playAgain) {
            System.out.println("Round " + roundNumber);
            System.out.println("I have generated a number between 1 and 100. Try to guess it!");
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number.");
                    totalScore += (maxAttempts - attempts + 1); // Score based on attempts left
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your current score: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next();

            if (!userResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            roundNumber++;
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
