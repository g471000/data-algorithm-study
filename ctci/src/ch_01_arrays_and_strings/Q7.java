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
        int len = array.length;
        for (int layer = 0; layer < len / 2; layer++) {
            int first = layer;
            int last = len - 1 - layer;
            for (int i = first; i < last; i++) {
               int offset = i - first;
                int top = array[first][i];
                array[first][i] = array[last - offset][first];
                array[last - offset][first] = array[last][last - offset];
                array[last][last - offset] = array[i][last];
                array[i][last] = top;
            }
        }
        return array;
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
