// https://leetcode.com/problems/number-of-islands/

package LeetCode;

public class NumberOfIslands {
    private void dfs(int row, int col, char[][] grid, boolean[][] visited, int[] dr, int[] dc) {
        visited[row][col] = true;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1'
                    && !visited[newRow][newCol]) {
                dfs(newRow, newCol, grid, visited, dr, dc);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited, dr, dc);
                    count++;
                }
            }
        }
        return count;
    }
}
