// https://practice.geeksforgeeks.org/problems/number-of-islands/1

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> ans = new ArrayList<>();

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int numOfIsland = 0;

        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            if (visited[row][col]) {
                ans.add(numOfIsland);
                continue;
            }

            visited[row][col] = true;
            numOfIsland++;

            for (int k = 0; k < 4; k++) {
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && visited[newRow][newCol]) {
                    int nodeNo = row * cols + col;
                    int adjNodeNo = newRow * cols + newCol;

                    if (ds.findParent(nodeNo) != ds.findParent(adjNodeNo)) {
                        numOfIsland--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            ans.add(numOfIsland);
        }
        return ans;
    }
}
