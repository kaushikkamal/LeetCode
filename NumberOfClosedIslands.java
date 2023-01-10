// https://leetcode.com/problems/number-of-closed-islands/description

package LeetCode;

public class NumberOfClosedIslands {
    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int[] dr, int[] dc) {
        visited[row][col] = true;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0
                    && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, visited, dr, dc);
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int count = 0;

        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 0 && !visited[0][col]) {
                dfs(grid, 0, col, visited, dr, dc);
            }

            if (grid[m - 1][col] == 0 && !visited[m - 1][col]) {
                dfs(grid, m - 1, col, visited, dr, dc);
            }
        }

        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 0 && !visited[row][0]) {
                dfs(grid, row, 0, visited, dr, dc);
            }

            if (grid[row][n - 1] == 0 && !visited[row][n - 1]) {
                dfs(grid, row, n - 1, visited, dr, dc);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(grid, i, j, visited, dr, dc);
                    count++;
                }
            }
        }

        return count;
    }
}
