// https://leetcode.com/problems/pacific-atlantic-water-flow/description/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private void dfs(int row, int col, int[][] heights, boolean[][] visited, int[] dr, int[] dc) {
        visited[row][col] = true;

        int m = heights.length;
        int n = heights[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && heights[newRow][newCol] >= heights[row][col] && !visited[newRow][newCol]) {
                dfs(newRow, newCol, heights, visited, dr, dc);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < m; row++) {
            if (!pacific[row][0]) {
                dfs(row, 0, heights, pacific, dr, dc);
            }

            if (!atlantic[row][n - 1]) {
                dfs(row, n - 1, heights, atlantic, dr, dc);
            }
        }

        for (int col = 0; col < n; col++) {
            if (!pacific[0][col]) {
                dfs(0, col, heights, pacific, dr, dc);
            }

            if (!atlantic[m - 1][col]) {
                dfs(m - 1, col, heights, atlantic, dr, dc);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    res.add(new ArrayList<>(Arrays.asList(row, col)));
                }
            }
        }
        return res;
    }

}
