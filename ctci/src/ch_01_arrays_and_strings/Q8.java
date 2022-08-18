package ch_01_arrays_and_strings;

import java.util.Arrays;
import java.util.Random;

public class Q8 {
    public static void main(String[] args) {
        Q8 q8 = new Q8();
        for (int i = 1; i < 10; i++) {
            int[][] input = q8.createSquareMatrix(i);
            System.out.println("Before:");
            q8.print2DArray(input);
            System.out.println("After:");
            q8.print2DArray(q8.setAsZero(input));
            System.out.println();
        }
    }

    public int[][] setAsZero(int[][] array) {
        if (array.length < 1) {
            return array;
        }
        for (int row = 1; row < array.length; row++) {
            for (int col = 1; col < array[0].length; col++) {
                if (array[row][col] == 0) {
                    array[row][0] = 0;
                    array[0][col] = 0;
                    if(row == 0 || col == 0){
                        array[row][col] = -1;
                    }
                }
            }
        }

        for (int row = 0; row < array.length; row++) {
            if(array[row][0] == 0){
                setRowZero(array, row);
            }
        }

        for (int col = 0; col < array[0].length; col++) {
            if (array[0][col] == 0) {
                setColZero(array, col);
            }
        }



        return array;
    }

    private void setRowZero(int[][] array, int row) {
        for (int col = 0; col < array[0].length; col++) {
            array[row][col] = 0;
        }
    }

    private void setColZero(int[][] array, int col) {
        for (int row = 0; row < array[0].length; row++) {
            array[row][col] = 0;
        }
    }

    private int[][] createSquareMatrix(int n) {
        Random r = new Random();
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               result[i][j] = r.nextInt(10);
            }
        }
        return result;
    }

    private void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
