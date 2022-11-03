// https://leetcode.com/problems/number-of-provinces/

package LeetCode;

public class NumberOfProvincesByDisjointSet {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int count = 0;

        DisjointSet ds = new DisjointSet(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (i == ds.findParent(i)) {
                count++;
            }
        }

        return count;
    }
}
