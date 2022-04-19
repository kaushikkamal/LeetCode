package LeetCode;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] image = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(image);
    }
}
