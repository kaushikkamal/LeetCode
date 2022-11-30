// https://leetcode.com/problems/find-the-town-judge/

package LeetCode;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];

        for (int[] edge : trust) {
            int src = edge[0];
            int dst = edge[1];
            count[dst]++; // for result, indegree - outdegree == n-1 // for every index, we find indegree - outdegree
            count[src]--;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge_(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] edge : trust) {
            int src = edge[0];
            int dst = edge[1];
            inDegree[dst]++;
            outDegree[src]++;
        }

        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
