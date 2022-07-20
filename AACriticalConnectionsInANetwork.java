// https://leetcode.com/problems/critical-connections-in-a-network/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

class AACriticalConnectionsInANetwork {
    // We record the timestamp that we visit each node. For each node, we check
    // every neighbor except its parent and return a smallest timestamp in all its
    // neighbors. If this timestamp is strictly less than the node's timestamp, we
    // know that this node is somehow in a cycle. Otherwise, this edge from the
    // parent to this node is a critical connection
    public ArrayList<ArrayList<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (ArrayList<Integer> oneConnection : connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        int timer[] = new int[1];
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtThatNode = new int[n];
        criticalConnectionsUtil(graph, -1, 0, timer, visited, results, timeStampAtThatNode);
        return results;
    }

    public void criticalConnectionsUtil(
            ArrayList<Integer>[] graph, int parent, int node, int timer[], boolean[] visited,
            ArrayList<ArrayList<Integer>> results, int[] timeStampAtThatNode) {
        visited[node] = true;
        timeStampAtThatNode[node] = timer[0]++;
        int currentTimeStamp = timeStampAtThatNode[node];

        for (int oneNeighbour : graph[node]) {
            if (oneNeighbour == parent) {
                continue;
            }
            if (!visited[oneNeighbour]) {
                criticalConnectionsUtil(graph, node, oneNeighbour, timer, visited, results, timeStampAtThatNode);
            }
            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node], timeStampAtThatNode[oneNeighbour]);
            if (currentTimeStamp < timeStampAtThatNode[oneNeighbour]) {
                results.add(Arrays.asList(node, oneNeighbour));
            }
        }
    }
}