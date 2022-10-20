package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ShortestPathInDirectedAcyclicGraph {
    static class Pair {
        int des, wt;

        Pair(int d, int w) {
            this.des = d;
            this.wt = w;
        }
    }

    private void dfs(int src, Deque<Integer> s, boolean[] visited, ArrayList<ArrayList<Pair>> adj) {
        visited[src] = true;

        for (Pair pair : adj.get(src)) {
            int des = pair.des;
            if (!visited[des]) {
                dfs(des, s, visited, adj);
            }
        }

        s.push(src);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        boolean[] visited = new boolean[N];
        Deque<Integer> s = new ArrayDeque<>();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, s, visited, adj);
            }
        }

        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[0] = 0;

        while (!s.isEmpty()) {
            int node = s.pop();
            int dis = distance[node];

            if (dis == Integer.MAX_VALUE) {
                continue;
            }

            for (Pair p : adj.get(node)) {
                distance[p.des] = Math.min(distance[p.des], dis + p.wt);
            }
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }
}
