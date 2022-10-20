// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphHavingUnitDistance {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            int dis = distance[node];

            for (int num : adj.get(node)) {
                int newDis = dis + 1;

                if (newDis < distance[num]) {
                    distance[num] = newDis;
                    q.offer(num);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        return distance;
    }
}
