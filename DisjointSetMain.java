package LeetCode;

import java.util.ArrayList;

class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int utpNode = findParent(parent.get(node));
        parent.set(node, utpNode);
        return parent.get(utpNode);
    }

    void unionByRank(int u, int v) {
        int utpU = findParent(u);
        int utpV = findParent(v);

        if (utpU == utpV) {
            return;
        }

        int rankU = rank.get(utpU);
        int rankV = rank.get(utpV);

        if (rankU < rankV) {
            parent.set(utpU, utpV);
        } else if (rankU > rankV) {
            parent.set(utpV, utpU);
        } else {
            parent.set(utpU, utpV);
            rank.set(utpV, rank.get(utpV) + 1);
        }
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

public class DisjointSetMain {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("same");
        } else {
            System.out.println("no same");
        }
        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("same");
        } else {
            System.out.println("no same");
        }
    }
}
