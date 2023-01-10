// https://leetcode.com/problems/as-far-from-land-as-possible/description

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    static class Pair {
        int row, col;

        Pair() {
        }

        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public int maxDistance(int[][] grid) {
        int distance = 0;
        int n = grid.length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    q.offer(new Pair(row, col));
                    visited[row][col] = true;
                }
            }
        }

        if (q.size() == 0 || q.size() == n * n) {
            return -1;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            distance++;

            while (size-- > 0) {
                Pair temp = q.poll();
                int row = temp.row;
                int col = temp.col;

                for (int i = 0; i < 4; i++) {
                    int newRow = row + dr[i];
                    int newCol = col + dc[i];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0
                            && !visited[newRow][newCol]) {
                        q.offer(new Pair(newRow, newCol));
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        return distance - 1;
    }
}
