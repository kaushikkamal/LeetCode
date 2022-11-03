package LeetCode;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdge = 0;
        int noOfConnectedComponents = 0;

        for (int i = 0; i < connections.length; i++) {
            int src = connections[i][0];
            int dst = connections[i][1];

            if (ds.findParent(src) == ds.findParent(dst)) {
                extraEdge++;
            } else {
                ds.unionBySize(src, dst);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == ds.findParent(i)) {
                noOfConnectedComponents++;
            }
        }

        --noOfConnectedComponents;

        if (extraEdge >= noOfConnectedComponents) {
            return noOfConnectedComponents;
        }

        return -1;
    }
}
