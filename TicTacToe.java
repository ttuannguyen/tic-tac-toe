import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("\nLet's play tic tac toe");

        // 1. Initialize the board with a 2D array.
        char[][] board = {
            { '_', '_', '_' }, 
            { '_', '_', '_' }, 
            { '_', '_', '_' }
          };

        
        // 3. For loop to handle each turn (of the 9 turns) of the player.
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("Turn: X");
                // Obtain the user's input for chosen position and assign it to the board
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.println("Turn: O");
                int[] spot = askUser(board);
                board[spot[0]][spot[1]] = 'O';
            }

            printBoard(board);  

            // 7. Conditional to announce the result
            int count = checkWin(board);

            if (count == 3) {
                System.out.println("X wins!");
                break;
            } else if (count == -3) {
                System.out.println("O wins");
                break;
            } else if (i == 8) {
                System.out.println("It's a tie!");
            }


        }
    

    }

    // 4. Function to ask and get the user's input each turn
    public static int[] askUser(char[][] board) {

        System.out.print(" - Pick a row and column number: ");

        int row = scan.nextInt();
        int element = scan.nextInt();

        while (board[row][element] != '_') {
            System.out.println("Spot taken! Try again.");
            row = scan.nextInt();
            element = scan.nextInt();
        }

        // returning a new integer array holding the position of row and column
        return new int[] {row, element};
        
    }

    
    // 5. Function to check for the win
    public static int checkWin(char[][] board) {
        int rows = checkRows(board);
        if (Math.abs(rows) == 3)
            return rows;
        
        int columns = checkColumns(board);
        if (Math.abs(columns) == 3)
            return columns;

        int leftDiagonal = checkLeftDiagonal(board);
        if (Math.abs(rows) == 3)
            return leftDiagonal;

        int rightDiagonal = checkRightDiagonal(board);
        if (Math.abs(rows) == 3)
            return rightDiagonal;

        // placeholder
        return -1;
    }

    
    // 6. Functions to check for rows, columns, and diagonals
    public static int checkRows(char[][] board) {
        int count = 0;
        
        // Operating logic: count X with ++ and count O with -- 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                } else if (board[i][j] == 'O') {
                    count--;
                }
            }
        }
        return count;
    }

    public static int checkColumns(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // By flipping i and j like below, we keep column position static and make row position dynamic as we go through each iteration
                if (board[j][i] == 'X') {
                    count++;
                } else if (board[j][i] == 'O') {
                    count--;
                }
            }
        }
        return count;
    }

    
    public static int checkLeftDiagonal(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][i] == 'X') {
                    count++;
                } else if (board[i][i] == 'O') {
                    count--;
                }
            }
        }
        return count;
    }

    public static int checkRightDiagonal(char[][] board) {
        int count = 0;
         for (int i = 0; i < board.length; i++) {
            if (board[2 - i][i] == 'X') {
                count++;
            } else if (board[i][i] == 'O') {
                count--;
            }
        }
        return count;
    }



    // 2. Function to print the board 
    public static void printBoard(char[][] board) {
        System.out.print("\n");  
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
            System.out.print(board[i][j] + " ");
            System.out.print("\n\n");  
          }
      }
    
}