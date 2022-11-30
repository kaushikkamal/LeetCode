// https://leetcode.com/problems/find-if-path-exists-in-graph/

package LeetCode;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];

            ds.unionBySize(src, dst);
        }

        if (ds.findParent(source) == ds.findParent(destination)) {
            return true;
        }
        return false;
    }
}
