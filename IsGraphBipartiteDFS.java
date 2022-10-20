package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class IsGraphBipartiteDFS {
    private boolean dfs(int src, int color, int[] colorArr, ArrayList<ArrayList<Integer>> adj) {
        colorArr[src] = color;

        for (int num : adj.get(src)) {
            if (colorArr[num] == -1) {
                if (dfs(num, 1 - color, colorArr, adj)) {
                    return true;
                }
            } else if (colorArr[num] == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
