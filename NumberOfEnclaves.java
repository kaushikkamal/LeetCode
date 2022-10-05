// https://leetcode.com/problems/number-of-enclaves/

package LeetCode;

class NumberOfEnclaves {

    private void dfs(int row, int col, boolean[][] visited, int[][] grid, int[] dr, int[] dc) {
        visited[row][col] = true;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1
                    && !visited[newRow][newCol]) {
                dfs(newRow, newCol, visited, grid, dr, dc);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) { // boundary of matrix
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, visited, grid, dr, dc);
                    }
                }
            }
        }

        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1 && !visited[0][col]) {
                dfs(0, col, visited, grid, dr, dc);
            }
            if (grid[m - 1][col] == 1 && !visited[m - 1][col]) {
                dfs(m - 1, col, visited, grid, dr, dc);
            }
        }

        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1 && !visited[row][0]) {
                dfs(row, 0, visited, grid, dr, dc);
            }
            if (grid[row][n - 1] == 1 && !visited[row][n - 1]) {
                dfs(row, n - 1, visited, grid, dr, dc);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}