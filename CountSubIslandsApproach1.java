// https://leetcode.com/problems/count-sub-islands/description/

package LeetCode;

public class CountSubIslandsApproach1 {
    private void dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == 0)
            return;
        grid[r][c] = 0;
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0) {
                    dfs(i, j, grid2);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs(i, j, grid2);
                    count++;
                }
            }
        }
        return count;
    }
}
