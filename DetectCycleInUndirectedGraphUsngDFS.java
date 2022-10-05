// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

package LeetCode;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraphUsngDFS {
    private boolean checkCyclesDFS(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int num : adj.get(node)) {
            if (!visited[num]) {
                if (checkCyclesDFS(num, node, visited, adj)) {
                    return true;
                }
            } else if (num != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCyclesDFS(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
