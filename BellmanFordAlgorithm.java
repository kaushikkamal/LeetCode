// https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int dis[] = new int[V];

        Arrays.fill(dis, (int) 1e8);
        dis[src] = 0;

        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> edge : edges) {
                int s = edge.get(0);
                int d = edge.get(1);
                int wt = edge.get(2);

                if (dis[s] == 1e8) {
                    continue;
                }

                if (dis[s] + wt < dis[d]) {
                    dis[d] = dis[s] + wt;
                }
            }
        }

        // check for negative weights cycle

        for (ArrayList<Integer> edge : edges) {
            int s = edge.get(0);
            int d = edge.get(1);
            int wt = edge.get(2);

            if (dis[s] != 1e8 && dis[s] + wt < dis[d]) {
                return new int[] { -1 };
            }
        }

        return dis;
    }
}
