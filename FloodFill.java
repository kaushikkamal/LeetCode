// https://leetcode.com/problems/flood-fill/

package LeetCode;

public class FloodFill {
    private void dfs(int[][] ans, int[][] image, int sr, int sc, int initialColor, int newColor, int[] dr, int[] dc) {
        ans[sr][sc] = newColor;

        int n = ans.length;
        int m = ans[0].length;

        for (int i = 0; i < 4; i++) {
            int row = sr + dr[i];
            int col = sc + dc[i];

            if (row >= 0 && row < n && col >= 0 && col < m && image[row][col] == initialColor
                    && ans[row][col] != newColor) {
                dfs(ans, image, row, col, initialColor, newColor, dr, dc);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int initialColor = image[sr][sc];

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        dfs(ans, image, sr, sc, initialColor, color, dr, dc);

        return ans;
    }
}
