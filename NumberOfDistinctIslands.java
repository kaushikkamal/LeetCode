// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    private String toString(int row, int col) {
        return row + " " + col;
    }

    private void dfs(int row, int col, int baseRow, int baseCol, ArrayList<String> shape,
            boolean[][] visited, int[][] grid) {

        visited[row][col] = true;
        shape.add(toString(row - baseRow, col - baseCol));

        int n = grid.length;
        int m = grid[0].length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(newRow, newCol, baseRow, baseCol, shape, visited, grid);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashSet<ArrayList<String>> hs = new HashSet<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, shape, visited, grid);
                    hs.add(shape);
                }
            }
        }
        return hs.size();
    }
}
