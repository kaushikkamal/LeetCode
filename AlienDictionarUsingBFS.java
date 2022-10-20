// https://practice.geeksforgeeks.org/problems/alien-dictionary/1

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionarUsingBFS {
    static ArrayList<Integer> toposort(int V, ArrayList<ArrayList<Integer>> adj) {
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

    public static String findOrder(String[] dict, int N, int K) {
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
