// https://leetcode.com/problems/max-area-of-island/description

package LeetCode;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxAreaOfIsland {

    private int dfs(int[][] grid, int row, int col, boolean[][] visited, int[] dr, int[] dc) {
        int m = grid.length;
        int n = grid[0].length;

        visited[row][col] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1
                    && !visited[newRow][newCol]) {
                count += dfs(grid, newRow, newCol, visited, dr, dc);
            }
        }
        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = dfs(grid, i, j, visited, dr, dc);
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }

    // OR

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, AtomicInteger count, int[] dr, int[] dc) {
        int m = grid.length;
        int n = grid[0].length;

        visited[row][col] = true;
        count.set(count.get() + 1);

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1
                    && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, visited, count, dr, dc);
            }
        }
    }

    public int maxAreaOfIsland_(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                AtomicInteger count = new AtomicInteger(0);
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited, count, dr, dc);
                }
                res = Math.max(res, count.get());
            }
        }

        return res;
    }
}
