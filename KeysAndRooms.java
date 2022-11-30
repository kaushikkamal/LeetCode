package LeetCode;

import java.util.List;

public class KeysAndRooms {
    private void dfs(int curNode, List<List<Integer>> rooms, boolean[] visited) {
        visited[curNode] = true;

        for (int adjNode : rooms.get(curNode)) {
            if (!visited[adjNode]) {
                dfs(adjNode, rooms, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0, rooms, visited);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
