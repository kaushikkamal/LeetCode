// https://leetcode.com/problems/sudoku-solver/

package LeetCode;

// ? TC: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.
// ? SC: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.

public class SudokuSolver {
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c)
                return false;

            if (board[i][col] == c)
                return false;

            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == c)
                return false;
        }
        return true;
    }

    private boolean solve(char[][] board, int row, int col) {
        for (int i = row; i < board.length; i++, col = 0) {
            for (int j = col; j < board.length; j++) {

                if (board[i][j] != '.') {
                    continue;
                }

                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;

                        if (solve(board, i, j + 1)) {
                            return true;
                        }

                        board[i][j] = '.';

                    }
                }

                // ? at that given index, if we cannot place any char from 1 to 9 then return false.
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}
