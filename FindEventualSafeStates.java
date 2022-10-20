// https://leetcode.com/problems/find-eventual-safe-states/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    private boolean dfs(int src, int[] visited, int[][] graph) {
        visited[src] = 2;

        for (int num : graph[src]) {
            if (visited[num] == 0) {
                if (dfs(num, visited, graph)) {
                    return true;
                }
            } else if (visited[num] == 2) {
                return true;
            }
        }

        visited[src] = 3;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, graph);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 3) {
                ans.add(i);
            }
        }

        return ans;
    }
}
