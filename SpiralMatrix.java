package LeetCode;

// https://leetcode.com/problems/spiral-matrix/
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int total = row * col;
        int up = 0, down = row - 1, left = 0, right = col - 1;

        while (list.size() < total) {
            for (int k = left; k <= right; k++) {
                list.add(matrix[up][k]);
            }
            up++;

            for (int k = up; k <= down; k++) {
                list.add(matrix[k][right]);
            }
            right--;

            for (int k = right; up <= down && k >= left; k--) {
                list.add(matrix[down][k]);
            }
            down--;

            for (int k = down; left <= right && k >= up; k--) {
                list.add(matrix[k][left]);
            }
            left++;

        }
        return list;
    }
}
