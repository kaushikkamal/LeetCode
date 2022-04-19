package LeetCode;

import java.util.Arrays;

public class SetMatrixZero {
    public static void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean col0 = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
            }

            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) {
                matrix[i][0] = 0;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(mat);
    }
}
