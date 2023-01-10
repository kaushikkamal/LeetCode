// https://leetcode.com/problems/possible-bipartition/description/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibleBipartitionDFS {
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] colorArr, int color) {
        colorArr[node] = color;

        for (int adj : adjList.get(node)) {
            if (colorArr[adj] == -1) {
                if (dfs(adj, adjList, colorArr, 1 - color)) {
                    return true;
                }
            } else if (colorArr[adj] == color) {
                return true;
            }
        }
        return false;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            int src = dislikes[i][0];
            int dst = dislikes[i][1];

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        int[] colorArr = new int[n + 1];
        Arrays.fill(colorArr, -1);

        for (int i = 1; i <= n; i++) {
            if (colorArr[i] == -1) {
                if (dfs(i, adjList, colorArr, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
