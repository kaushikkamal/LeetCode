// https://leetcode.com/problems/count-sub-islands/description/

package LeetCode;

public class CountSubIslandsApproach2 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(i, j, grid2, dr, dc);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs(i, j, grid2, dr, dc);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, int[][] grid, int[] dr, int[] dc) {
        grid[row][col] = 0;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol, grid, dr, dc);
            }
        }
    }
}
