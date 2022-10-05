// https://leetcode.com/problems/rotting-oranges/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first, second, time;

    Pair(int f, int s, int t) {
        this.first = f;
        this.second = s;
        this.time = t;
    }
}

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] ans = grid;
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int time = 0;
        int count = 0;
        int countFresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int r = pair.first;
            int c = pair.second;
            int t = pair.time;

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int newRow = r + dr[i];
                int newCol = c + dc[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1
                        && ans[newRow][newCol] != 2) {
                    q.offer(new Pair(newRow, newCol, t + 1));
                    ans[newRow][newCol] = 2;
                    count++;
                }
            }
        }

        if (countFresh != count) {
            return -1;
        }

        return time;
    }
}
