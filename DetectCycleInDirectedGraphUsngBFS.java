// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirectedGraphUsngBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int num : adj.get(i)) {
                indegree[num]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();

            topo.add(temp);

            for (int num : adj.get(temp)) {
                indegree[num]--;

                if (indegree[num] == 0) {
                    q.offer(num);
                }
            }
        }

        if (topo.size() != V) {
            return true;
        }
        return false;
    }
}
