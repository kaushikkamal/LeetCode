// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    private int dfs(ArrayList<ArrayList<Integer>> adjList, int curNode, List<Boolean> hasApple, boolean[] visited) {
        int res = 0;

        for (int adj : adjList.get(curNode)) {
            if (!visited[adj]) {
                visited[adj] = true;
                res += dfs(adjList, adj, hasApple, visited);
            }
        }

        if ((res > 0 || hasApple.get(curNode)) && curNode != 0) {
            res += 2;
        }

        return res;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        visited[0] = true;

        return dfs(adjList, 0, hasApple, visited);
    }
}
