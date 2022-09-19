/**
 *  @author jgold
 *   Joseph Goldberger 
 *   My program has a static bollean MagicBoard method that takes a 2d integer array, a 2d array boolean
 *   array, a start position and a number based on that position. It then checks which
 *   direction it can move in based off that number without going off the board. If it can
 *   move in a certain direction it does so recursively until it either reaches the number
 *   0 or until it can't move in a safe direction anymore (or it can't move backwards because
 *   of the boolean array). It will then unwind checking for all safe directions. If it finds
 *   0 it will return true, if it exhausts all options it will return false
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class recursion {
    public static void main(String[] args) throws FileNotFoundException {


        Random random = new Random();
        int max = 20;
        int min = 5;

        //random number between 20 and 5
        int d =random.nextInt(max + 1 - min) + min;
        PrintWriter pw;
        File file = new File("Output file recursion.txt");
        int random3 = random.nextInt(((d-1)-1)+1)+1;
        int random4 = random.nextInt(((d-1)-1)+1)+1;


        int board[][] = new int[d][d];
        boolean board2[][] = new boolean[d][d];

        pw = new PrintWriter(new FileOutputStream(file,true));

        //generating board and print to file and console
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                board[i][j] = random.nextInt(((d-1)-1)+1)+1;
            }
        }

        board[random3][random4] = 0;

        for(int i=0; i<d; i++){
            pw.println();
            for (int j=0; j<d; j++){
                pw.print(board[i][j] + " ");
            }
        }
        pw.println();
        pw.close();

        int start;
        int random2 = random.nextInt(4);

        //random start position

        if(random2 == 0){
            pw = new PrintWriter(new FileOutputStream(file,true));
            pw.println("\nThe starting position chosen randomly between the four corners is" +
                    " the top left corner\n");
            System.out.println("\nThe starting position chosen randomly between the four corners is" +
                    " the top left corner\n");
            start = board [0][0];
            pw.println(move(board,start,0,0,board2));
            System.out.println(false);
            pw.close();


        }
        else if(random2 == 1){
            pw = new PrintWriter(new FileOutputStream(file,true));
            pw.println("\nThe starting position chosen randomly between the four corners is" +
                    " the top right corner\n");
            System.out.println("\nThe starting position chosen randomly between the four corners is" +
                    " the top right corner\n");
            start = board[0][d-1];
            pw.println(move(board,start,0,d-1,board2));
            System.out.println(false);
            pw.close();
        }
        else if (random2 == 2){
            pw = new PrintWriter(new FileOutputStream(file,true));
            pw.println("\nThe starting position chosen randomly between the four corners is" +
                    " the bottom left corner\n");
            System.out.println("\nThe starting position chosen randomly between the four corners is" +
                    " the bottom left corner\n");
            start = board[d-1][0];
            pw.println(move(board,start,d-1,0,board2));
            System.out.println(false);
            pw.close();

        }
        else if (random2 == 3){
            pw = new PrintWriter(new FileOutputStream(file,true));
            pw.println("\nThe starting position chosen randomly between the four corners is" +
                    " the bottom right corner\n");
            System.out.println("\nThe starting position chosen randomly between the four corners is" +
                    " the bottom right corner\n");
            start = board[d-1][d-1];
            pw.println(move(board,start,d-1,d-1,board2));
            System.out.println(false);
            pw.close();

        }
    }

    /**
     * @param board - 2d integer board
     * @param number - integer at the start position
     * @param row - start position row
     * @param column - start position column
     * @param board2 - 2d boolean array
     * @return - true or false
     * @throws FileNotFoundException
     */

    public static boolean move(int [][] board, int number, int row, int column, boolean [][]board2) throws FileNotFoundException {

        int temp;
        int temp2;
        PrintWriter pw;
        File file = new File("Output file recursion.txt");

        pw = new PrintWriter(new FileOutputStream(file,true));

        if(number==0){
            System.out.println(true);
            pw.println(true);
            pw.close();
            System.exit(0);
        }

        //moving east
        if(number+column < board.length) {
            if(!board2[row][column + number]) {
                temp = column;
                column = number + column;
                temp2 = number;
                number = board[row][column];
                board2[row][column] = true;
                System.out.println("moved east to " + number + " from " + row + " row, " +temp + " column");
                move(board, number, row, column, board2);
                column = temp;
                number = temp2;
            }
        }

        //moving west
        if(column-number >= 0){
            if(!board2[row][column - number]) {
                temp = column;
                column = column - number;
                temp2 = number;
                number = board[row][column];
                board2[row][column] = true;
                System.out.println("moved west to " + number + " from " + row + " row, " +temp + " column");
                move(board, number, row, column, board2);
                column = temp;
                number = temp2;


            }
        }

        //moving south
        if(row + number < board.length) {
            if (!board2[row + number][column]) {
                temp = row;
                row = row + number;
                temp2 = number;
                number = board[row][column];
                board2[row][column] = true;
                System.out.println("moved south to " + number + " from " + temp + " row, " +column + " column");
                move(board, number, row, column, board2);
                row = temp;
                number = temp2;


            }
        }

        //moving north
        if(row-number >= 0) {
            if (!board2[row - number][column]) {
                temp = row;
                row = row - number;
                number = board[row][column];
                board2[row][column] = true;
                System.out.println("moved north to " + number + " from " + temp + " row, " +column + " column");
                move(board, number, row, column, board2);

            }
        }

        //if all paths have been exhausted and number is not zero
        return false;
    }
}
