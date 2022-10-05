// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int cur, parent;

    Pair() {
    }

    Pair(int c, int p) {
        this.cur = c;
        this.parent = p;
    }
}

public class DetectCycleInUndirectedGraphUsngBFS {
    private boolean checkCyclesBFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node, -1));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            node = temp.cur;
            int parent = temp.parent;

            for (int num : adj.get(node)) {
                if (!visited[num]) {
                    visited[num] = true;
                    q.offer(new Pair(num, node));
                } else if (num != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCyclesBFS(i, visited, adj)) {
                    return true;
                }

            }
        }
        return false;
    }
}
