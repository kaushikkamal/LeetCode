// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

package LeetCode;

import java.util.ArrayList;

public class RatInAMaze1 {

    // ? Approach 1

    private static void solve2(int i, int j, String op, int[][] M, boolean[][] visited, ArrayList<String> ans,
            int N, int[] di, int[] dj) {

        if (i == N - 1 && j == N - 1) {
            ans.add(op);
            return;
        }

        String dir = "DLRU";

        for (int index = 0; index < 4; index++) {
            System.out.println("index " + index);
            int nextIIndex = i + di[index];
            int nextJIndex = j + dj[index];

            System.out.println("nextIIndex " + nextIIndex);
            System.out.println("nextJIndex " + nextJIndex);
            System.out.println("visited[nextIIndex][nextJIndex] " + visited[nextIIndex][nextJIndex]);
            System.out.println("M[nextIIndex][nextJIndex] " + M[nextIIndex][nextJIndex]);

            if (nextIIndex >= 0 && nextJIndex >= 0 && nextIIndex < N && nextJIndex < N
                    && !visited[nextIIndex][nextJIndex] && M[nextIIndex][nextJIndex] == 1) {
                visited[i][j] = true;
                solve2(nextIIndex, nextJIndex, op + dir.charAt(index), M, visited, ans, N, di, dj);
                visited[i][j] = false;
            }
        }
    }

    public static ArrayList<String> findPath(int[][] M, int N) {

        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        int[] di = { 1, 0, 0, -1 };
        int[] dj = { 0, -1, 1, 0 };

        if (M[0][0] == 0) {
            ans.add("-1");
            return ans;
        }

        solve2(0, 0, "", M, visited, ans, N, di, dj);
        return ans;
    }

    // ----------------------------------------------

    // ? Approach 2

    // ----------------------------------------------

    private static void solve(int row, int col, String op, int[][] M, boolean[][] visited, ArrayList<String> list,
            int N) {

        if (row == N - 1 && col == N - 1) {
            list.add(op);
            return;
        }

        // down
        if (row + 1 < N && !visited[row + 1][col] && M[row + 1][col] == 1) {
            visited[row][col] = true;
            solve(row + 1, col, op + "D", M, visited, list, N);
            visited[row][col] = false;
        }

        // left
        if (col - 1 >= 0 && !visited[row][col - 1] && M[row][col - 1] == 1) {
            visited[row][col] = true;
            solve(row, col - 1, op + "L", M, visited, list, N);
            visited[row][col] = false;
        }

        // right
        if (col + 1 < N && !visited[row][col + 1] && M[row][col + 1] == 1) {
            visited[row][col] = true;
            solve(row, col + 1, op + "R", M, visited, list, N);
            visited[row][col] = false;
        }

        // Up
        if (row - 1 >= 0 && !visited[row - 1][col] && M[row - 1][col] == 1) {
            visited[row][col] = true;
            solve(row - 1, col, op + "U", M, visited, list, N);
            visited[row][col] = false;
        }
    }

    public static ArrayList<String> findPath_(int[][] M, int N) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        if (M[0][0] == 0) {
            ans.add("-1");
            return ans;
        }
        solve(0, 0, "", M, visited, ans, N);
        return ans;
    }
}