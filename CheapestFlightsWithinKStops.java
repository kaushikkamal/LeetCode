// https://leetcode.com/problems/cheapest-flights-within-k-stops/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    class Pair {
        int node, cost, step;

        Pair() {
        }

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        Pair(int n, int c, int s) {
            this.node = n;
            this.cost = c;
            this.step = s;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Pair> q = new LinkedList<>();
        int[] costArr = new int[n];

        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[src] = 0;
        q.offer(new Pair(src, 0, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int node = temp.node;
            int cost = temp.cost;
            int step = temp.step;

            if (step > k) {
                continue;
            }

            for (Pair p : adj.get(node)) {
                if (cost + p.cost < costArr[p.node]) {
                    costArr[p.node] = cost + p.cost;
                    q.offer(new Pair(p.node, costArr[p.node], step + 1));
                }
            }
        }

        if (costArr[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return costArr[dst];
    }
}
