package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStopsSequence {
    class Pair {
        int node, cost, step;
        ArrayList<Integer> seq;

        Pair() {
        }

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        Pair(int n, int c, int s, ArrayList<Integer> seq) {
            this.node = n;
            this.cost = c;
            this.step = s;
            this.seq = seq;
        }
    }

    public ArrayList<Integer> findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        ArrayList<Integer> res = new ArrayList<>();
        int resCost = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<>();
        int[] costArr = new int[n];

        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[src] = 0;
        q.offer(new Pair(src, 0, 0, new ArrayList<>(Arrays.asList(0))));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int node = temp.node;
            int cost = temp.cost;
            int step = temp.step;
            ArrayList<Integer> seq = temp.seq;

            if (node == dst && step <= k + 1 && cost < resCost) {
                resCost = cost;
                res = seq;
            }

            for (Pair p : adj.get(node)) {
                if (cost + p.cost < costArr[p.node]) {
                    ArrayList<Integer> newSeq = new ArrayList<>(seq);
                    newSeq.add(p.node);
                    costArr[p.node] = cost + p.cost;
                    q.offer(new Pair(p.node, costArr[p.node], step + 1, newSeq));
                }
            }
        }
        return res;
    }
}
