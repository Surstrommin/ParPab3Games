/**
 * Partner Lab 3
 *This program is a guessing game to guess the exact number within a limited number of times.
 * @author1 RichardYoung
 * @author2 Zaing Thint Myat
 * @date 24/Mar
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {//Create a game menu.
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Play Guessing Game");
            System.out.println("2. Play Rock Paper Scissors");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {//Limit the input type to characters, only 1, 2, 3 are allowed
                case "1":
                    GuessingGame.gameRuleGuessingGame();  //Calling methods and classes at GuessingGame
                    break;
                case "2":
                    RockPaperScissors.gameRuleRPS(null);  //Calling methods and classes at RockPaperScissors
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Enter 1, 2, or 3.");//Tips for exceeding legal numbers
            }
        }
    }
}