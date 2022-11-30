// https://leetcode.com/problems/maximum-total-importance-of-roads/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        long maxImportance = 0;
        long[] degree = new long[n];

        for (int i = 0; i < roads.length; i++) {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }

        Arrays.sort(degree);

        int importance = 1;

        for (long deg : degree) {
            maxImportance += (deg * importance);
            importance++;
        }
        return maxImportance;
    }

    // 2nd Appraoch

    class Pair implements Comparable<Pair> {
        int node, degree;

        Pair(int n, int d) {
            this.node = n;
            this.degree = d;
        }

        public int compareTo(Pair p) {
            return p.degree - this.degree;
        }
    }

    public long maximumImportance_(int n, int[][] roads) {
        ArrayList<Pair> degreeList = new ArrayList<>();
        int[] degree = new int[n];
        long maxImportance = 0;

        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dst = roads[i][1];

            degree[src]++;
            degree[dst]++;
        }

        for (int i = 0; i < n; i++) {
            degreeList.add(new Pair(i, degree[i]));
        }

        Collections.sort(degreeList);

        int importance = n;
        for (Pair p : degreeList) {
            int node = p.node;
            degree[node] = importance;
            importance--;
        }

        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dst = roads[i][1];

            maxImportance += (degree[src] + degree[dst]);
        }
        return maxImportance;
    }
}