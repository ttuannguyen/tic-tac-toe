import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("\nLet's play tic tac toe");

        char[][] board = {
            { '_', '_', '_' }, 
            { '_', '_', '_' }, 
            { '_', '_', '_' }
          };

        
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Turn: X");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.println("Turn: O");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
            }
        }
        
        printBoard(board);  


    }

    public static int[] askUser(char[][] board) {

        System.out.print("Pick a row and column number");

        int row = scan.nextInt();
        int element = scan.nextInt();

        while (board[row][element] != '_') {
            System.out.println("Spot taken! Try again.");
            row = scan.nextInt();
            element = scan.nextInt();
        }

        return new int[] {row, element};
        // returning a new integer array holding the row and column
    }

    public static void printBoard(char[][] board) {
        System.out.print("\n");  
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
            System.out.print(board[i][j] + " ");
            System.out.print("\n\n");  
          }
      }
    
}