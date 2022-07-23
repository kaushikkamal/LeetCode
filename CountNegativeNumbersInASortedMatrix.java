// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

public class CountNegativeNumbersInASortedMatrix {

    // TC -> O(M+N) M = row , N = column
    // SC -> O(1)

    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int i = 0;
        int j = col - 1;
        int res = 0;

        // start from top right

        while (i < row && j >= 0) {
            if (grid[i][j] < 0) {
                res += (row - i);
                j--;
            } else {
                i++;
            }
        }

        return res;
    }

    // TC -> O(Mlog(N)) M = row , N = column
    // SC -> O(1)

    public int countNegatives_(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int res = 0;
        int lastNegative = col - 1;

        for (int i = 0; i < row; i++) {

            if (grid[i][0] < 0) {
                res += grid[i].length;
                continue;
            }

            if (grid[i][grid[i].length - 1] > 0) {
                continue;
            }

            int start = 0;
            int end = lastNegative;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (grid[i][mid] < 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            res += (grid[i].length - start);
            lastNegative = start;
        }

        return res;
    }
}
