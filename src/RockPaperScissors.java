/**
 * Rock-Paper-Scissors Game
 * This is a program allow user to play RPS game with a computer and computer generate randomly.
 * The game continues until the user quits.
 * @author Zaing Thint Myat
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void gameRuleRPS(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Do you want to play? (yes/no): ");
            String play = scanner.nextLine().trim().toLowerCase();
            if (!play.equals("yes")) {
                System.out.println("Good Bye!");
                break;
            }
            System.out.print("Enter your choice: 1. paper, 2. scissors, 3. rock: ");
            int userChoice;
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice < 1 || userChoice > 3) {
                    System.out.println("Invalid choice! Please choose a number between 1 and 3.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }
            int computerChoice = random.nextInt(3) + 1;
            String[] choices = {"paper", "scissors", "rock"};
            System.out.println("You chose " + choices[userChoice - 1]);
            System.out.println("Computer chose " + choices[computerChoice - 1]);
            if (userChoice == computerChoice) {
                System.out.println("It is a tie!");
            } else if ((userChoice == 1 && computerChoice == 3) ||
                    (userChoice == 2 && computerChoice == 1) ||
                    (userChoice == 3 && computerChoice == 2)) {
                System.out.println("You win!");
            } else {
                System.out.println("You lost! :P");
            }
        }
        scanner.close();
    }
}