// https://leetcode.com/problems/matrix-diagonal-sum/description/

package LeetCode;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[n - 1 - i][i];
        }

        if ((n & 1) == 1) {
            return sum - mat[n / 2][n / 2];
        }

        return sum;
    }
}
