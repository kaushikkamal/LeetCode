// https://leetcode.com/problems/path-with-maximum-gold/

package LeetCode;

public class PathWithMaximumGold {

    // ? Approach 1

    private static int solve(int[][] grid, boolean[][] visited, int count, int row, int col, int m, int n, int[] di,
            int[] dj) {

        int curCount = 0;

        for (int i = 0; i < 4; i++) {
            int nexti = row + di[i];
            int nextj = col + dj[i];

            if (nexti >= 0 && nextj >= 0 && nexti < m && nextj < n && !visited[nexti][nextj]
                    && grid[nexti][nextj] != 0) {
                visited[row][col] = true;
                curCount = Math.max(curCount,
                        solve(grid, visited, count + grid[nexti][nextj], nexti, nextj, m, n, di, dj));
                visited[row][col] = false;
            }
        }

        return Math.max(count, curCount);
    }

    public static int getMaximumGold(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    ans = Math.max(ans, solve(grid, visited, grid[i][j], i, j, m, n, di, dj));
                }
            }
        }
        return ans;
    }

    // ----------------------------------------------

    // ? Approach 2

    // ----------------------------------------------

    private static int solve(int[][] grid, boolean[][] visited, int count, int row, int col, int m, int n) {

        int down = 0, left = 0, right = 0, up = 0;

        // down
        if (row + 1 >= 0 && row + 1 < m && !visited[row + 1][col] && grid[row + 1][col] != 0) {
            visited[row][col] = true;
            down = solve(grid, visited, count + grid[row + 1][col], row + 1, col, m, n);
            visited[row][col] = false;
        }

        // left
        if (col - 1 >= 0 && col - 1 < n && !visited[row][col - 1] && grid[row][col - 1] != 0) {
            visited[row][col] = true;
            left = solve(grid, visited, count + grid[row][col - 1], row, col - 1, m, n);
            visited[row][col] = false;
        }

        // right
        if (col + 1 >= 0 && col + 1 < n && !visited[row][col + 1] && grid[row][col + 1] != 0) {
            visited[row][col] = true;
            right = solve(grid, visited, count + grid[row][col + 1], row, col + 1, m, n);
            visited[row][col] = false;
        }

        // down
        if (row - 1 >= 0 && row - 1 < m && !visited[row - 1][col] && grid[row - 1][col] != 0) {
            visited[row][col] = true;
            up = solve(grid, visited, count + grid[row - 1][col], row - 1, col, m, n);
            visited[row][col] = false;
        }

        return Math.max(count, Math.max(down, Math.max(left, Math.max(right, up))));
    }

    public int getMaximumGold_(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    ans = Math.max(ans, solve(grid, visited, grid[i][j], i, j, m, n));
                }
            }
        }
        return ans;
    }
}
