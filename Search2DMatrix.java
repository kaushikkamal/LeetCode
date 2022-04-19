package LeetCode;

class Search2DMatrix {

    // https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        int row = matrix.length;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
