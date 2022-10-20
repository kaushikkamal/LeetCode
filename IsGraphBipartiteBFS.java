// https://leetcode.com/problems/is-graph-bipartite/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartiteBFS {
    private boolean bfs(int node, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int tempColor = color[temp];

            for (int num : adj.get(temp)) {
                if (color[num] == -1) {
                    color[num] = 1 - tempColor;
                    // color[num] = (tempColor == 0) ? 1 : 0;
                    q.offer(num);
                } else if (color[num] == tempColor) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
