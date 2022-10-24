// https://leetcode.com/problems/path-with-minimum-effort/

package LeetCode;

import java.util.PriorityQueue;

// TC -> O(E logV) -> O(n*m*4 * log(n*m))
// SC -> O(n*m)

class Pair {
    int row, col, effort;

    Pair() {
    }

    Pair(int r, int c, int e) {
        this.row = r;
        this.col = c;
        this.effort = e;
    }
}

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.effort - y.effort);

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                effort[i][j] = Integer.MAX_VALUE;
            }
        }

        effort[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int row = temp.row;
            int col = temp.col;
            int curEffort = temp.effort;

            if (row == n - 1 && col == m - 1) {
                return curEffort;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newEffort = Math.max(curEffort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        pq.offer(new Pair(newRow, newCol, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}
