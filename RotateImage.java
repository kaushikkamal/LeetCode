// https://leetcode.com/problems/rotate-image/
package LeetCode;

import java.util.Arrays;

public class RotateImage {
    // rotate the image by 90 degrees (clockwise).
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

    // rotate the image by 90 degrees (anti-clockwise).
    public static void rotateAntiClockwise(int[][] matrix) {
        int N = matrix.length;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row != col && row <= col) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }

        for (int row = 0; row < N / 2; row++) {
            int[] temp = matrix[row];
            matrix[row] = matrix[N - row - 1];
            matrix[N - row - 1] = temp;
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(image[2][0]);
        // rotate(image);
        System.out.println("------------------");
        rotateAntiClockwise(image);
    }
}
