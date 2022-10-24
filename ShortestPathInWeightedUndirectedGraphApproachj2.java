// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node, wt;

    Pair() {
    }

    Pair(int n, int w) {
        this.node = n;
        this.wt = w;
    }
}

class QueueData {
    int node, dis;

    QueueData() {
    }

    QueueData(int n, int d) {
        this.node = n;
        this.dis = d;
    }
}

public class ShortestPathInWeightedUndirectedGraphApproachj2 {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            int wt = edges[i][2];

            adj.get(src).add(new Pair(des, wt));
            adj.get(des).add(new Pair(src, wt));
        }

        PriorityQueue<QueueData> pq = new PriorityQueue<QueueData>((x, y) -> x.dis - y.dis);
        int[] distance = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean isReached = false;

        for (int i = 1; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        distance[1] = 0;
        pq.offer(new QueueData(1, 0));

        while (!pq.isEmpty()) {
            QueueData temp = pq.poll();
            int node = temp.node;
            int dis = temp.dis;

            if (node == n) {
                isReached = true;
                break;
            }

            for (Pair p : adj.get(node)) {
                if (dis + p.wt < distance[p.node]) {
                    distance[p.node] = dis + p.wt;
                    parent[p.node] = node;
                    pq.offer(new QueueData(p.node, distance[p.node]));
                }
            }
        }

        if (isReached) {
            int des = n;
            List<Integer> res = new LinkedList<>();
            while (parent[des] != des) {
                res.add(0, des);
                des = parent[des];
            }
            res.add(0, 1);
            return res;
        }

        List<Integer> res = new ArrayList<>(Arrays.asList(-1));
        return res;
    }

}
