// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
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
    ArrayList<Integer> seq;
    int dis;

    QueueData() {
        this.seq = new ArrayList<>();
    }

    QueueData(ArrayList<Integer> list, int d) {
        this.seq = list;
        this.dis = d;
    }
}

public class ShortestPathInWeightedUndirectedGraphApproachj1 {
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

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        pq.offer(new QueueData(new ArrayList<>(Arrays.asList(1)), 0));

        while (!pq.isEmpty()) {
            QueueData temp = pq.poll();
            ArrayList<Integer> seq = temp.seq;
            int dis = temp.dis;

            int lastNode = seq.get(seq.size() - 1);

            // lastNode is destination
            if (lastNode == n) {
                List<Integer> ans = seq;
                return ans;
            }

            for (Pair p : adj.get(lastNode)) {
                if (dis + p.wt < distance[p.node]) {
                    ArrayList<Integer> tempList = new ArrayList<>(seq);
                    tempList.add(p.node);

                    distance[p.node] = dis + p.wt;
                    pq.offer(new QueueData(tempList, distance[p.node]));
                }
            }
        }

        List<Integer> res = new ArrayList<>(Arrays.asList(-1));
        return res;
    }

}
