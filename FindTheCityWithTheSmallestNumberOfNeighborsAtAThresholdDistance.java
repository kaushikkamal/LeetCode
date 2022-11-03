// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    // diajkstra

    class Pair {
        int node, dis;

        Pair() {
        }

        Pair(int n, int d) {
            this.node = n;
            this.dis = d;
        }
    }

    private int dijkstra(int n, int src, ArrayList<ArrayList<Pair>> adj, int distanceThreshold) {
        int adjCity = 0;
        int[] distance = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dis - y.dis);

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().dis;
            pq.poll();

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int adjWt = p.dis;

                if (dis + adjWt < distance[adjNode]) {
                    distance[adjNode] = dis + adjWt;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        for (int cost : distance) {
            if (cost != Integer.MAX_VALUE && cost <= distanceThreshold) {
                adjCity++;
            }
        }
        return adjCity;
    }

    public int findTheCity_(int n, int[][] edges, int distanceThreshold) {
        int city = -1;
        int countAdj = n;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            int wt = edges[i][2];

            adj.get(src).add(new Pair(dst, wt));
            adj.get(dst).add(new Pair(src, wt));
        }

        for (int i = 0; i < n; i++) {
            int adjCity = dijkstra(n, i, adj, distanceThreshold);

            if (adjCity <= countAdj) {
                countAdj = adjCity;
                city = i;
            }
        }
        return city;
    }

    // Floyd Warshall

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            int cost = edges[i][2];

            dis[src][dst] = cost;
            dis[dst][src] = cost;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][via] == Integer.MAX_VALUE || dis[via][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dis[i][j] = Math.min(dis[i][j], dis[i][via] + dis[via][j]);
                }
            }
        }

        int cityNo = -1;
        int countCity = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            int neighbour = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (city != adjCity && dis[city][adjCity] <= distanceThreshold) {
                    neighbour++;
                }
            }

            if (neighbour <= countCity) {
                countCity = neighbour;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
