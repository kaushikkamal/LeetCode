package LeetCode;

// https://leetcode.com/problems/n-queens/
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static boolean isSafe(int row, int col, char[][] board) {

        int i, j, r, c;
        // vertical
        for (i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // horizontal
        for (j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // upper left
        r = row;
        for (c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // upper right
        r = row;
        for (c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // lower left
        r = row;
        for (c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // lower right
        r = row;
        for (c = col; r < board.length && c < board.length; r++, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoard) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoard.add(newBoard);
    }

    public static void solve(char[][] board, List<List<String>> allBoard, int col) {

        if (col == board.length) {
            saveBoard(board, allBoard);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';

                solve(board, allBoard, col + 1);

                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];

        solve(board, allBoard, 0);

        return allBoard;
    }
}
