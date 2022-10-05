// https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col, dis;

    Pair() {
    }

    Pair(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dis = d;
    }
}

public class DistanceOfNearestCellHaving1 {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.dis;

            distance[row][col] = dis;

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0
                        && !visited[newRow][newCol]) {
                    q.offer(new Pair(newRow, newCol, dis + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return distance;
    }
}
