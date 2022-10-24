// https://leetcode.com/problems/shortest-path-in-binary-matrix/

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

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            if (grid[0][0] == 0)
                return 1;
            else
                return -1;
        }

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 },
                { -1, -1 } };
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.dis;

            if (row == n - 1 && col == n - 1) {
                return dis + 1;
            }

            for (int i = 0; i < 8; i++) {
                int newRow = row + dirs[i][0];
                int newCol = col + dirs[i][1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = -1;
                    q.offer(new Pair(newRow, newCol, dis + 1));
                }
            }
        }
        return -1;
    }
}
