package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithmUsingPQ {
    static class Pair {
        int node, dis;

        Pair(int n, int d) {
            this.node = n;
            this.dis = d;
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dis - y.dis);

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        pq.offer(new Pair(S, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int dis = p.dis;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (dis + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dis + edgeWeight;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        return distance;
    }
}
