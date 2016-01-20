package hminhas.minesweeper;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Hassan on 09/10/2015.
 */
public class Board {
    private int width;
    private int height;
    private int numberOfMines;
    private squares [][] board;
    private squares value;
    private squares[] intToSquares;


    public Board(int width, int height, int numberOfMines){
        this.width = width-1;
        this.height = height-1;
        this.numberOfMines = numberOfMines;
        intToSquares = new squares[]{squares.ZERO, squares.ONE,value.TWO,value.THREE,value.FOUR,value.FIVE,value.SIX,value.SEVEN,value.EIGHT};
        board = new squares [width] [height];
        createMines();
        addNumbers();
        Log.d("Array", "deep arr: " + Arrays.deepToString(board));

    }

    public squares getValue(int r,int c){
        return board[r][c];
    }

    public void createMines(){
        Random random = new Random();
        int temp;
        int row, column;

        for (int j = 0; j < numberOfMines; j++) {
            column = random.nextInt(width-0) + 0;
            row = random.nextInt(height-0) + 0;
            board[row][column] = value.MINE;
        }
    }
    public void addNumbers(){
        for(int row=0;row<=width;row++){
            for(int col=0;col<=height;col++){

                int count=0;
                if (board[row][col] == value.MINE){
                    continue;
                }
                // checks top left corner
                if(row == 0 && col==0){
                    if (board[row][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col+1] == value.MINE){
                        count++;
                    }
                } else if(row == 0 && col==width){  // checks top right corner
                    if (board[row][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col-1] == value.MINE){
                        count++;
                    }
                } else if(row == height && col==0){ //check bottom left corner
                    if (board[row-1][col] == value.MINE){
                        count++;
                    }

                    if (board[row][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col+1] == value.MINE){
                        count++;
                    }
                } else if(row == height && col==width){ //check bottom right corner
                    if (board[row-1][col] == value.MINE){
                        count++;
                    }

                    if (board[row][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col-1] == value.MINE){
                        count++;
                    }
                } else if (row == 0 && (col >0 && col<=width)){ // checks top row
                    if (board[row][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row][col+1] == value.MINE){
                        count++;
                    }
                } else if (row == height && (col >0 && col<= width)){ //check bottom row
                    if (board[row][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row][col+1] == value.MINE){
                        count++;
                    }
                } else if (col == 0 && (row > 0 && row <= height)){ //check first column
                    if (board[row-1][col] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col] == value.MINE){
                        count++;
                    }
                } else if (col == width && (row > 0 && row <= height)){ //checks last column
                    if (board[row-1][col] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col] == value.MINE){
                        count++;
                    }
                } else if ((col>0 && row>0)&&(col<=width&&row<=height)){
                    if (board[row-1][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col] == value.MINE){
                        count++;
                    }

                    if (board[row-1][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row][col+1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col-1] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col] == value.MINE){
                        count++;
                    }

                    if (board[row+1][col+1] == value.MINE){
                        count++;
                    }
                }

                board[row][col] = intToSquares[count];

            }
        }
    }
}
