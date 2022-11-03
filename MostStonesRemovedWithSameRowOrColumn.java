// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/submissions/

package LeetCode;

import java.util.ArrayList;

class DisjointSet {
    private ArrayList<Integer> size = new ArrayList<>();
    private ArrayList<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    int getSize(int node) {
        return size.get(node);
    }

    int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int utpNode = findParent(parent.get(node));
        parent.set(node, utpNode);

        return parent.get(utpNode);
    }

    void unionBySize(int u, int v) {
        int utpU = findParent(u);
        int utpV = findParent(v);

        if (utpU == utpV) {
            return;
        }

        int sizeU = size.get(utpU);
        int sizeV = size.get(utpV);

        if (sizeU < sizeV) {
            parent.set(utpU, utpV);
            size.set(utpV, size.get(utpU) + size.get(utpV));
        } else {
            parent.set(utpV, utpU);
            size.set(utpU, size.get(utpU) + size.get(utpV));
        }
    }
}

class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        int totalNode = maxRow + maxCol + 1;
        DisjointSet ds = new DisjointSet(totalNode);

        for (int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            ds.unionBySize(nodeRow, nodeCol);
        }

        for (int i = 0; i < totalNode; i++) {
            if (ds.findParent(i) == i && ds.getSize(i) > 1) {
                count++;
            }
        }

        return stones.length - count;
    }
}
