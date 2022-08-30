// https://leetcode.com/problems/n-queens/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    // ? Optimal Approach

    private void solve(int col, boolean[] left, boolean[] topLeft, boolean[] bottomLeft, char[][] board,
            List<List<String>> ans, int n) {

        if (col == n) {
            List<String> temp = new ArrayList<>();
            for (char[] ch : board) {
                temp.add(new String(ch));
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (left[row] || bottomLeft[row + col] || topLeft[(n - 1) + (col - row)]) {
                continue;
            }

            board[row][col] = 'Q';
            left[row] = true;
            bottomLeft[row + col] = true;
            topLeft[(n - 1) + (col - row)] = true;

            solve(col + 1, left, topLeft, bottomLeft, board, ans, n);

            board[row][col] = '.';
            left[row] = false;
            bottomLeft[row + col] = false;
            topLeft[(n - 1) + (col - row)] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] ch : board) {
            Arrays.fill(ch, '.');
        }

        boolean[] left = new boolean[n];
        boolean[] topLeft = new boolean[2 * n - 1];
        boolean[] bottomLeft = new boolean[2 * n - 1];

        solve(0, left, topLeft, bottomLeft, board, ans, n);

        return ans;
    }

    // ? Brute Force Approach

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int tempRow = row;
        int tempCol = col;

        // upper left
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = tempRow;
        col = tempCol;

        // left
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        col = tempCol;

        // bottom left
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    private void solve_(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] ch : board) {
                list.add(new String(ch));
            }
            ans.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve_(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens_(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] ch : board) {
            Arrays.fill(ch, '.');
        }

        solve_(0, board, ans, n);

        return ans;
    }
}
