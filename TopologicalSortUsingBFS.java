// https://practice.geeksforgeeks.org/problems/topological-sort/1

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
    ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

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

            res.add(temp);

            for (int num : adj.get(temp)) {
                indegree[num]--;
                if (indegree[num] == 0) {
                    q.offer(num);
                }
            }
        }
        return res;
    }
}
