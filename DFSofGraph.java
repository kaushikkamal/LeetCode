// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DFSofGraph {
    // public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>>
    // adj) {
    // ArrayList<Integer> ans = new ArrayList<>();
    // boolean[] visited = new boolean[V];

    // Deque<Integer> stack = new ArrayDeque<>();
    // stack.push(0);
    // visited[0] = true;

    // while (!stack.isEmpty()) {
    // int node = stack.pop();
    // ans.add(node);

    // for (int num : adj.get(node)) {
    // if (!visited[num]) {
    // stack.push(num);
    // visited[num] = true;
    // }
    // }
    // }

    // return ans;
    // }

    private void dfs(int node, boolean[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        ans.add(node);

        for (int num : adj.get(node)) {
            if (!visited[num]) {
                dfs(num, visited, ans, adj);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph_(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(0, visited, ans, adj);

        return ans;
    }
}
