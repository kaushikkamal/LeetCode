// https://practice.geeksforgeeks.org/problems/alien-dictionary/1

package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class AlienDictionarUsingDFS {
    void dfs(int src, Deque<Integer> s, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = true;

        for (int num : adj.get(src)) {
            if (!visited[num]) {
                dfs(num, s, visited, adj);
            }
        }

        s.push(src);
    }

    ArrayList<Integer> toposort(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> s = new ArrayDeque<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, s, visited, adj);
            }
        }

        while (!s.isEmpty()) {
            res.add(s.pop());
        }

        return res;
    }

    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int j = 0;
            int len = Math.min(s1.length(), s2.length());

            while (j < len) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
                j++;
            }
        }

        ArrayList<Integer> res = toposort(K, adj);
        StringBuilder sb = new StringBuilder();

        for (int num : res) {
            sb.append((char) (num + (int) ('a')));
        }

        return sb.toString();
    }
}
