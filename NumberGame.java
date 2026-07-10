import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("===== Welcome to the Number Guessing Game =====");

        do {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int guess;
            int attempts = 0;
            int maxAttempts = 7;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("🎉 Congratulations! You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);

                    score += (maxAttempts - attempts + 1) * 10;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Remaining Attempts: " + (maxAttempts - attempts));
            }

            if (attempts == maxAttempts && randomNumber != -1) {
                System.out.println("❌ You lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Current Score: " + score);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n===== Game Over =====");
        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}