// https://leetcode.com/problems/all-paths-from-source-to-target/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {

    // DFS
    private void dfs(int curNode, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        path.add(curNode);

        if (curNode == graph.length - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int adjNode : graph[curNode]) {
                dfs(adjNode, graph, path, res);
            }
        }

        path.remove(path.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph, path, res);
        return res;
    }

    // BFS
    class Pair {
        int node;
        List<Integer> path;

        Pair(int n, List<Integer> l) {
            this.node = n;
            this.path = l;
        }
    }

    public List<List<Integer>> allPathsSourceTarget_(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, new ArrayList<>(Arrays.asList(0))));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            List<Integer> path = p.path;

            if (node == n - 1) {
                res.add(path);
                continue;
            }

            for (int adjNode : graph[node]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(adjNode);
                q.offer(new Pair(adjNode, newPath));
            }
        }
        return res;
    }
}
