// https://leetcode.com/problems/reachable-nodes-with-restrictions/description/

package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class ReachableNodesWithRestrictions {
    private void dfs(int curNode, ArrayList<ArrayList<Integer>> adj, boolean[] visited, HashSet<Integer> restrictedSet,
            AtomicInteger countReachableNodes) {

        countReachableNodes.set(countReachableNodes.get() + 1);
        visited[curNode] = true;

        for (int adjNode : adj.get(curNode)) {
            if (!restrictedSet.contains(adjNode) && !visited[adjNode]) {
                dfs(adjNode, adj, visited, restrictedSet, countReachableNodes);
            }
        }
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> restrictedSet = new HashSet<>();
        boolean[] visited = new boolean[n];
        AtomicInteger countReachableNodes = new AtomicInteger(0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];

            adj.get(src).add(dst);
            adj.get(dst).add(src);
        }

        for (int each : restricted) {
            restrictedSet.add(each);
        }

        dfs(0, adj, visited, restrictedSet, countReachableNodes);

        return countReachableNodes.get();
    }
}
