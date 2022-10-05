// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofGraph {

    // for Disconnected Graph

    public ArrayList<Integer> bfsOfDisconnectedGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    bfs.add(node);

                    ArrayList<Integer> cur = adj.get(node);

                    for (int num : cur) {
                        if (!visited[num]) {
                            visited[num] = true;
                            q.offer(num);
                        }
                    }
                }
            }
        }

        return bfs;
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            ArrayList<Integer> cur = adj.get(node);

            for (int num : cur) {
                if (!visited[num]) {
                    q.offer(num);
                    visited[num] = true;
                }
            }
        }
        return bfs;
    }
}
