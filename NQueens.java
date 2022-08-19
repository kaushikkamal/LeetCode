// https://leetcode.com/problems/n-queens/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
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

    private void solve(int col, char[][] board, List<List<String>> ans, int n) {
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
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] ch : board) {
            Arrays.fill(ch, '.');
        }

        solve(0, board, ans, n);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
