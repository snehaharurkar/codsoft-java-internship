import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("===== NUMBER GUESSING GAME =====");

        while (playAgain) {

            int targetNumber = random.nextInt(100) + 1;  // 1-100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");

                // Check valid input
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scanner.next();
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;

                int diff = Math.abs(userGuess - targetNumber);

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;

                    int points = (maxAttempts - attempts) + 1;
                    totalScore += points;

                    System.out.println("You earned " + points + " points!");
                    break;
                } 
                else if (diff <= 5) {
                    if (userGuess > targetNumber) {
                        System.out.println("🔥 Very close! A little low.");
                    } else {
                        System.out.println("🔥 Very close! A little high.");
                    }
                }
                else if (userGuess > targetNumber) {
                    System.out.println("Too high!");
                } 
                else {
                    System.out.println("Too low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ You ran out of attempts!");
                System.out.println("The correct number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            playAgain = choice.equals("yes");
        }

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Your final score: " + totalScore);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}


