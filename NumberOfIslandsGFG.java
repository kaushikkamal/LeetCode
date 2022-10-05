// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first, second;

    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

public class NumberOfIslandsGFG {

    private void BFS(int i, int j, boolean[][] visited, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        visited[i][j] = true;

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            i = q.peek().first;
            j = q.peek().second;
            q.poll();

            for (int row = -1; row <= 1; row++) {
                for (int col = -1; col <= 1; col++) {
                    int newRow = i + row;
                    int newCol = j + col;

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1'
                            && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        q.offer(new Pair(newRow, newCol));
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    BFS(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
}