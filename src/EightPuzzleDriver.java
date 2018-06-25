import java.util.Scanner;
import java.util.Stack;

/**
 * @author John Berkley
 * CPP Class: CS420
 * Date Created: Feb 7, 2018
 */

public class EightPuzzleDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EightPuzzle puzzle = new EightPuzzle();
        String userChoice;

        do {
            //display menu
            System.out.println("\n~~~~ Menu ~~~~");
            System.out.println("1) Generate Random Puzzle");
            System.out.println("2) Enter a puzzle");
            System.out.println("3) Quit\n");
            System.out.print("Enter your choice as a number: ");
            userChoice = input.nextLine();

            switch (userChoice) {
                //random puzzle
                case "1":
                    int [][] puzzleTemp = {{0, 1, 2},
                                           {3, 4, 5},
                                           {6, 7, 8}};
                    puzzleTemp = puzzle.generateRandomPuzzles(puzzleTemp, 100);
                    Stack<EightPuzzleBoard> moves = puzzle.aStarSearch(puzzleTemp, 0);
                    Stack<EightPuzzleBoard> moves1 = puzzle.aStarSearch(puzzleTemp, 1);
                    System.out.println();
                    puzzle.printMoves(moves1);
                    break;
                //manually entered puzzle
                case "2":
                    System.out.println("Please Enter Your Puzzle On One Line With Each Number Separated By Spaces");
                    String line1 = input.nextLine();
                    String []lineOneData = line1.split(" ");
                    int [][]userPuzzle = {{Integer.parseInt(lineOneData[0]), Integer.parseInt(lineOneData[1]), Integer.parseInt(lineOneData[2])},
                            {Integer.parseInt(lineOneData[3]), Integer.parseInt(lineOneData[4]), Integer.parseInt(lineOneData[5])},
                            {Integer.parseInt(lineOneData[6]), Integer.parseInt(lineOneData[7]), Integer.parseInt(lineOneData[8])}};
                    Stack<EightPuzzleBoard> moves2 = puzzle.aStarSearch(userPuzzle, 0);
                    Stack<EightPuzzleBoard> moves3 = puzzle.aStarSearch(userPuzzle, 1);
                    puzzle.printMoves(moves3);
                    break;
                //exit
                case "3":
                    System.out.println("\nGoodbye");
                    break;
                //handle for bad input
                default:
                    System.out.println("Error: Invalid Selection, Please Try Again.");
            }

        } while (!userChoice.equals("3"));
    }
}
