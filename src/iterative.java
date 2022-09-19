/**
 *  @author jgold
 *   Joseph Goldberger - 21958283
 *   For COMP 352 Section H - Fall 2020
 *   Assignment 2 - version 2
 *   Due Date: October 25, 2020
 *
 *   This is version 2 of the programming part for assignment 1. My program has a
 *   static bollean MagicBoard method that takes a 2d integer array, a 2d array boolean
 *   array, a stack of positions, and a start position. It will then check through a loop
 *   that will go until my stack is empty. It does the same thing as version 1 checking
 *   to see if it can find position zero but inseatd of recursively it keeps putting new
 *   positions into a stack (emulating recursive).
 */

import java.io.*;
import java.util.Random;
import java.util.Stack;

public class iterative {
    public static void main(String[] args) throws FileNotFoundException {
        Random random = new Random();
        int max = 20;
        int min = 5;
        //generating random number between 5 and 20
        int d =random.nextInt(max + 1 - min) + min;

        PrintWriter pw;
        File file = new File("Output file iterative.txt");
        int random3 = random.nextInt(((d-1)-1)+1)+1;
        int random4 = random.nextInt(((d-1)-1)+1)+1;

        Stack<Position> stack = new Stack<>();
        int x = 0;
        int y =0;

        Position position = new Position(x,y);

        int board[][] = new int[d][d];
        boolean board2[][] = new boolean[d][d];

        pw = new PrintWriter(new FileOutputStream(file,true));

        //generating the board with a random position of zero then printing said board
        //to console and the the file

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                board[i][j] = random.nextInt(((d-1)-1)+1)+1;
            }
        }

        board[random3][random4] = 0;

        for(int i=0; i<d; i++){
            System.out.println();
            pw.println();
            for (int j=0; j<d; j++){
                System.out.print(board[i][j] + " ");
                pw.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
        pw.println();
        pw.close();

        int random2 = random.nextInt(4);

        //choosing start position of the four coners
        switch (random2) {
            case 0:
                pw = new PrintWriter(new FileOutputStream(file, true));
                pw.println("\nThe starting position chosen randomly between the four corners is" +
                        " the top left corner\n");
                System.out.println("\nThe starting position chosen randomly between the four corners is" +
                        " the top left corner\n");
                position.setRow(0);
                position.setColumn(0);
                stack.push(position);
                pw.println(MagicBoard(board, board2, stack, position));
                pw.close();


                break;
            case 1:
                pw = new PrintWriter(new FileOutputStream(file, true));
                pw.println("\nThe starting position chosen randomly between the four corners is" +
                        " the top right corner\n");
                System.out.println("\nThe starting position chosen randomly between the four corners is" +
                        " the top right corner\n");
                position.setRow(0);
                position.setColumn(d - 1);
                stack.push(position);
                pw.println(MagicBoard(board, board2, stack, position));
                pw.close();
                break;
            case 2:
                pw = new PrintWriter(new FileOutputStream(file, true));
                pw.println("\nThe starting position chosen randomly between the four corners is" +
                        " the bottom left corner\n");
                System.out.println("\nThe starting position chosen randomly between the four corners is" +
                        " the bottom left corner\n");
                position.setRow(d - 1);
                position.setColumn(0);
                stack.push(position);
                pw.println(MagicBoard(board, board2, stack, position));
                pw.close();

                break;
            case 3:
                pw = new PrintWriter(new FileOutputStream(file, true));
                pw.println("\nThe starting position chosen randomly between the four corners is" +
                        " the bottom right corner\n");
                System.out.println("\nThe starting position chosen randomly between the four corners is" +
                        " the bottom right corner\n");
                position.setColumn(d - 1);
                position.setRow(d - 1);
                stack.push(position);
                pw.println(MagicBoard(board, board2, stack, position));
                pw.close();

                break;
        }

            System.out.println(MagicBoard(board,board2,stack,position));



        long startTime = System.currentTimeMillis( );
        long endTime = System.currentTimeMillis( ); // record the ending time
        long elapsed = (endTime - startTime);

        System.out.println("\nelapsed time is " + elapsed);
    }

    /**
     * @param board - 2d array of integers
     * @param board2 - 2d array of boolean
     * @param stack - stack of position
     * @param position - start position
     * @return - boolean
     * @throws FileNotFoundException
     */

    public static boolean MagicBoard(int [] [] board, boolean board2 [][], Stack<Position> stack, Position position) throws FileNotFoundException {

        int row;
        int column;
        int number;
        int temp;
        PrintWriter pw;
        File file = new File("Output file iterative.txt");

        pw = new PrintWriter(new FileOutputStream(file,true));

        while(!stack.isEmpty()){

            position = stack.pop();
            row = position.getRow();
            column = position.getColumn();

            number = board[row][column];

            if(number==0){
                System.out.println(true);
                pw.println(true);
                pw.close();
                System.exit(0);
            }

            //moving east
            if(number + column < board.length){
                if(board2[row][column+number]==false){
                    temp = column;
                    column = number + column;
                    Position position1 = new Position(row,column);
                    stack.push(position1);
                    board2[row][column] = true;
                    System.out.println("moved east to " + position1 +  " at number " + board[row][column]);
                    column = temp;

                }
            }



            //moving west
            if(column - number >= 0){
                if(board2[row][column-number]==false){
                    temp = column;
                    column = column-number;
                    Position position1 = new Position(row,column);
                    stack.push(position1);
                    board2[row][column] = true;
                    System.out.println("moved west to " + position1+  " at number " + board[row][column]);
                    column = temp;
                }
            }

            //moving south
            if(number + row < board.length){
                if(board2[row+number][column]==false){
                    temp = row;
                    row = number + row;
                    Position position1 = new Position(row,column);
                    stack.push(position1);
                    board2[row][column] = true;
                    System.out.println("moved south to " + position1 +  " at number " + board[row][column]);
                    row = temp;
                }
            }



            //moving north
            if(row - number >= 0){
                if(board2[row-number][column]==false){
                    row = row-number;
                    Position position1 = new Position(row,column);
                    stack.push(position1);
                    board2[row][column] = true;
                    System.out.println("moved north to " + position1 + " at number " + board[row][column]);
                }
            }


        }

        return false;
    }
}

