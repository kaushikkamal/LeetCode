// https://leetcode.com/problems/possible-bipartition/description/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartitionBFS {
    private boolean bfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] colorArr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        colorArr[node] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int tempColor = colorArr[temp];

            for (int adj : adjList.get(temp)) {
                if (colorArr[adj] == -1) {
                    colorArr[adj] = 1 - tempColor;
                    q.offer(adj);
                } else if (colorArr[adj] == tempColor) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            int src = dislikes[i][0];
            int dst = dislikes[i][1];

            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }

        int[] colorArr = new int[n + 1];
        Arrays.fill(colorArr, -1);

        for (int i = 1; i <= n; i++) {
            if (colorArr[i] == -1) {
                if (bfs(i, adjList, colorArr)) {
                    return false;
                }
            }
        }
        return true;
    }
}
