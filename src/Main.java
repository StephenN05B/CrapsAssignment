import java.util.Random;
import java.util.Scanner;

public class Main {


    public static int rollSingleDie() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;  // Generates a number between 1 and 6
    }


    public static int rollTwoDice() {
        int firstDie = rollSingleDie();
        int secondDie = rollSingleDie();
        int total = firstDie + secondDie;
        System.out.println("Rolled: " + firstDie + " + " + secondDie + " = " + total);
        return total;
    }


    public static void startGame() {
        Scanner input = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("\nNew game started... Rolling the dice...");
            int totalRoll = rollTwoDice();

            // 2,3,12 = loss
            if (totalRoll == 2 || totalRoll == 3 || totalRoll == 12) {
                System.out.println("Craps! You lose this round.");
            }
            // 7 or 11 = win
            else if (totalRoll == 7 || totalRoll == 11) {
                System.out.println("Natural! You win this round."); // WIN CONDITION
            }

            else {
                int establishedPoint = totalRoll;
                System.out.println("Your point is now set to " + establishedPoint + ". Roll again to hit the point!");

                boolean continueRolling = true;
                while (continueRolling) {
                    System.out.println("Rolling the dice again...");
                    int currentRoll = rollTwoDice();

                    if (currentRoll == 7) {
                        System.out.println("Rolled a 7! You lose.");
                        continueRolling = false;
                    } else if (currentRoll == establishedPoint) {
                        System.out.println("You hit the point! You win.");
                        continueRolling = false;
                    } else {
                        System.out.println("Keep trying for the point...");
                    }
                }
            }

            // rematch
            System.out.print("\nWould you like to play again? (yes/no): ");
            String playerResponse = input.nextLine().trim().toLowerCase();
            if (!playerResponse.equals("yes")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing!");
        input.close();
    }

    public static void main(String[] args) {
        startGame();
    }
}
