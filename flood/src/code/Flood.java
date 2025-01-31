package code;

import java.util.Scanner;

public class Flood {

    public static void main(String[] args) {
        int replay;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a number to begin the flood!");

        do {
            LinkedGrid grid = new LinkedGrid(10); // Creates a 10x10 grid
            grid.display(); // Displays the initial grid
            int moves = 0;
            int maxMoves = 25;

            while (moves < maxMoves) {
                System.out.print("Enter a color (1-6): ");
                int color = userInput.nextInt();

                grid.flood(color); // Flood the grid with the chosen color

                if (grid.winCheck(color)) {
                    System.out.println("You won in " + moves + " moves!");
                    break;
                }

                moves++;
                System.out.println((maxMoves - moves) + " moves remaining.");
            }

            System.out.println("Play again? (1: Yes, 0: No)");
            replay = userInput.nextInt();

        } while (replay == 1);

        userInput.close(); // Close the scanner to prevent resource leaks
        System.out.println("Thanks for playing!");
    }
}
