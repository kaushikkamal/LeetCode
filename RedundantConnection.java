// https://leetcode.com/problems/redundant-connection/description/

package LeetCode;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        int redundantSrc = -1;
        int redundantDst = -1;

        for (int i = 0; i < n; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];

            if (ds.findParent(src) == ds.findParent(dst)) {
                redundantSrc = src;
                redundantDst = dst;
            } else {
                ds.unionBySize(src, dst);
            }
        }
        return new int[] { redundantSrc, redundantDst };
    }
}
