// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    static class Pair {
        int row, col, distance;

        Pair() {
        }

        Pair(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.distance = d;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        q.offer(new Pair(entrance[0], entrance[1], 0));
        visited[entrance[0]][entrance[1]] = true;

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.distance;

            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && (row != entrance[0] || col != entrance[1])) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.'
                        && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    q.offer(new Pair(newRow, newCol, dis + 1));
                }
            }
        }
        return -1;
    }
}
