// https://leetcode.com/problems/search-a-2d-matrix-ii/

// TC -> O(M+N) // M ros N col
// SC -> O(1)

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
