// https://leetcode.com/problems/number-of-provinces/

package LeetCode;

import java.util.ArrayList;

public class NumberOfProvinces {

    private void DFS(int node, boolean[] visited, int[][] isConnected) {
        visited[node] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                DFS(i, visited, isConnected);
            }
        }
    }

    public int findCircleNum_(int[][] isConnected) {
        int V = isConnected[0].length;
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, visited, isConnected);
            }
        }
        return count;
    }

    private void DFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int num : adj.get(node)) {
            if (!visited[num]) {
                DFS(num, visited, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[] visited = new boolean[V + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int count = 0;

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i + 1).add(j + 1);
                    adj.get(j + 1).add(i + 1);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, visited, adj);
            }
        }
        return count;
    }
}
