package ch_01_arrays_and_strings;

import java.util.Arrays;
import java.util.Random;

public class Q7 {
    public static void main(String[] args) {
        Q7 q7 = new Q7();
        int[][] input = q7.createNxN(5);
        q7.print2DArray(input);
        System.out.println();

        int[][] result = q7.rotate2DArray(input);
        q7.print2DArray(result);
    }

    public int[][] rotate2DArray(int[][] array) {
        int size = array.length;
        int[][] result = new int[size][size];
        int start = 0;
        int end = size - 1;
        for (int j = 0; j < size / 2; j++) {
            for (int i = j; i < end - j; i++) {
                result[i][end] = array[j][i];
                result[end][end -i] = array[i][end];
                result[end - i][j] = array[end][end - i];
                result[start + j][i + j] = array[end - i][j];
            }
        }
        return result;
    }

    private int[][] createNxN(int size) {
        Random r = new Random();
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
