package ch_01_arrays_and_strings;

public class Q8 {
    public static void main(String[] args) {

    }

    public int[][] setAsZero(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == 0) {
                    array[row][0] = 0;
                    array[0][col] = 0;
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
}
