// https://practice.geeksforgeeks.org/problems/topological-sort/1

package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class TopologicalSortUsingDFS {
    private static void dfs(int src, Deque<Integer> s, boolean[] visited,
            ArrayList<ArrayList<Integer>> adj) {

        visited[src] = true;

        for (int num : adj.get(src)) {
            if (!visited[num]) {
                dfs(num, s, visited, adj);
            }
        }

        s.push(src);
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] res = new int[V];
        Deque<Integer> s = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, s, visited, adj);
            }
        }

        int i = 0;
        while (!s.isEmpty()) {
            res[i] = s.pop();
            i++;
        }

        return res;
    }
}
