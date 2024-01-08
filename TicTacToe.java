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
            } else {
                System.out.println("Turn: O");
            }
        }

        
        printBoard(board);  


    }

    // public static int[] askUser(char[][] board) {
    //     System.out.println("\nPlease pick a row and column number");

    //     int row = scan.nextInt();
    //     int element = scan.nextInt();
    //     return new int[] {row, element};
    // }

    public static void printBoard(char[][] board) {
        System.out.print("\n");  
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
            System.out.print(board[i][j] + " ");
            System.out.print("\n\n");  
          }
      }
    
}