// https://leetcode.com/problems/flood-fill/

package LeetCode;

import java.util.Arrays;

public class FloodFill {
    private void dfs(int[][] newImage, int[][] image, int sr, int sc, int color, int[] dr, int[] dc) {
        int m = image.length;
        int n = image[0].length;

        newImage[sr][sc] = color;

        for (int i = 0; i < 4; i++) {
            int newRow = sr + dr[i];
            int newCol = sc + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && newImage[newRow][newCol] == image[sr][sc]
                    && newImage[newRow][newCol] != color) {
                dfs(newImage, image, newRow, newCol, color, dr, dc);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int[][] newImage = new int[m][n];

        for (int i = 0; i < m; i++) {
            newImage[i] = Arrays.copyOf(image[i], image[i].length);
        }

        dfs(newImage, image, sr, sc, color, dr, dc);

        return newImage;
    }
}
