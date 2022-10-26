package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    class Pair {
        int node, cost;

        Pair() {
        }

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] distance = new int[n];
        int[] ways = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.cost - y.cost);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dst = roads[i][1];
            int cost = roads[i][2];

            adj.get(src).add(new Pair(dst, cost));
            adj.get(dst).add(new Pair(src, cost));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));

        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int cost = pq.peek().cost;
            pq.poll();

            if (node == n - 1) {
                continue;
            }

            for (Pair p : adj.get(node)) {
                int newNode = p.node;
                int newCost = cost + p.cost;

                if (newCost < distance[newNode]) {
                    distance[newNode] = newCost;
                    ways[newNode] = ways[node];
                    pq.offer(new Pair(newNode, newCost));
                } else if (newCost == distance[newNode]) {
                    ways[newNode] = (ways[newNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }

    // Approach 2 (TLE on LC Submission)
    public int countPaths_(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] distance = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.cost - y.cost);
        int resCost = Integer.MAX_VALUE;
        int resNum = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dst = roads[i][1];
            int cost = roads[i][2];

            adj.get(src).add(new Pair(dst, cost));
            adj.get(dst).add(new Pair(src, cost));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int cost = pq.peek().cost;
            pq.poll();

            for (Pair p : adj.get(node)) {
                int newNode = p.node;
                int newCost = cost + p.cost;

                if (newNode == n - 1) {
                    if (newCost == resCost) {
                        resNum++;
                    }
                    if (newCost < resCost) {
                        resCost = newCost;
                        resNum = 1;
                    }
                    continue;
                }

                if (newCost <= distance[newNode]) {
                    if (newCost < distance[newNode]) {
                        distance[newNode] = newCost;
                    }

                    pq.offer(new Pair(newNode, newCost));
                }
            }
        }
        return resNum;
    }
}
