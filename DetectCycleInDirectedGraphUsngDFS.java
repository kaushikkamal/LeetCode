// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

package LeetCode;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphUsngDFS {
    private boolean dfs(int src, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = 2;

        for (int num : adj.get(src)) {
            if (visited[num] == 0) {
                if (dfs(num, visited, adj)) {
                    return true;
                }
            } else if (visited[num] == 2) {
                return true;
            }
        }
        visited[src] = 1;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
