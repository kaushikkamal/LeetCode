// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

package LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MSTPrims {
    class Pair {
        int node, wt;

        Pair() {
        }

        Pair(int n, int w) {
            this.node = n;
            this.wt = w;
        }
    }

    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.wt - y.wt);
        boolean[] visited = new boolean[V];
        int costSum = 0;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int wt = pq.peek().wt;
            pq.poll();

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            costSum += wt;
            // store the edge in a data structure

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWt = adj.get(node).get(i).get(1);

                if (!visited[adjNode]) {
                    pq.offer(new Pair(adjNode, edgeWt));
                }
            }
        }
        return costSum;
    }
}
