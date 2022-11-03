package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

class DisjointSet {
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
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

    void unionBySize(int u, int v) {
        int utpU = findParent(u);
        int utpV = findParent(v);

        if (utpU == utpV)
            return;

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

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    Edge(int s, int d, int w) {
        this.source = s;
        this.destination = d;
        this.weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class MSTKruskal {
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int costSum = 0;
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int src = i;
                int dst = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);

                edges.add(new Edge(src, dst, wt));
            }
        }

        Collections.sort(edges);

        DisjointSet ds = new DisjointSet(V);

        for (Edge e : edges) {
            int src = e.source;
            int dst = e.destination;
            int wt = e.weight;

            if (ds.findParent(src) != ds.findParent(dst)) {
                costSum += wt;
                ds.unionBySize(src, dst);
                // store the edge in a data structure
            }
        }
        return costSum;
    }
}
