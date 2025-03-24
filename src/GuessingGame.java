/**
 * @author RichardYoung
 * @compareNumber The purpose of the compare method is to compare the number input by the user with a randomly generated number.
 * Within this method, counting is utilized, hence it is necessary to pass guessNumber, randomNumber, and count as parameters for comparison.
 * Moreover, since the range of the numbers is greater than the range of the count, no bugs will occur in this scenario.
 * @gameRuleGuessingGame This class is used for basic game rules.
 * In which a loop is created to determine whether the user meets the game rules.
 * The number of games and the range of numbers generated are limited.
 * If the user is within the specified range, a success or failure status is returned.
 */

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void gameRuleGuessingGame() {
        int count = 5;//Create a counter as an instance variable for use in upcoming methods.
        // I want to limit game attempts to under 5.
        System.out.println("I'm thinking of a number between 50 and 500.");
        System.out.println("Guess what it is. You have 5 tries: " + count);
        //Method to get numbers from the keyboard.
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();//Create a new random number
        int randomNumber = rand.nextInt(500 - 50 + 1) + 50;//Store the random number in an `int`.
        int guessNumber;//Define a variable for the guessed number, which will be used later.
        while (count > 0) {//A loop method to determine if the input number triggers subsequent actions.
            while (true) {
                System.out.println("Please enter a number between 50(above) and 500(above).");
                if (sc.hasNextInt()) {//Invoke a method to check if it's an integer.
                    guessNumber = sc.nextInt();//Assign the input value detected from the keyboard to `guessNumber`.
                    if (guessNumber >= 50 && guessNumber <= 500) {//If the number meets the calculation conditions
                        break;//Input is valid, exit the loop.
                    } else {
                        System.out.println("The text is wrong, please re-enter");
                    }
                }
            }
            boolean isCorrect = compareNumber(guessNumber, randomNumber, count);//【The Key point in doc！】
            if (isCorrect) {//Because of true is default value
                break;//Right answer and exit loop
            }
            count--;//Chance -1 in each loop
            if (count == 0) {//Determine the number of attempts remaining
                //If the judgment fails multiple times, the correct number will be output
                System.out.println("Unfortunately, the opportunity has run out. The right number is：" + randomNumber);
            }
        }
        System.out.print("Do you want to continue or exit? (Type Y to continue, N to exit):");
        String option = sc.next();
        if (option.equalsIgnoreCase("Y")) {
            gameRuleGuessingGame();
        } else {
            System.out.println("Bye bye, see you next time~~~");
        }
    }

    public static boolean compareNumber(int guessNumber, int randomNumber, int count) {//【The Key point in doc！】
        if (guessNumber == randomNumber) {
            System.out.println("Great, you did it!");
            return true;
        } else {
            if (guessNumber > randomNumber) {
                System.out.println("Nope! Too high. Try again,and you have just " + (count - 1) + " times to try.");
            } else {
                System.out.println("Nope! Too low. Try again,and you have just " + (count - 1) + " times to try.");
            }
            return false;
        }
    }
}