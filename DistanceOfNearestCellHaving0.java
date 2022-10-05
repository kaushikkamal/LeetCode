// https://leetcode.com/problems/01-matrix/

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

public class DistanceOfNearestCellHaving0 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distance = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
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

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]
                        && mat[newRow][newCol] != 0) {
                    q.offer(new Pair(newRow, newCol, dis + 1));
                    visited[newRow][newCol] = true;
                }

            }
        }
        return distance;
    }
}
