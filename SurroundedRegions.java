// https://leetcode.com/problems/surrounded-regions/

package LeetCode;

public class SurroundedRegions {
    private void dfs(int row, int col, boolean[][] visited, char[][] board, int[] dr, int[] dc) {
        visited[row][col] = true;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] == 'O'
                    && !visited[newRow][newCol]) {
                dfs(newRow, newCol, visited, board, dr, dc);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O' && !visited[0][col]) {
                dfs(0, col, visited, board, dr, dc);
            }

            if (board[m - 1][col] == 'O' && !visited[m - 1][col]) {
                dfs(m - 1, col, visited, board, dr, dc);
            }
        }

        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O' && !visited[row][0]) {
                dfs(row, 0, visited, board, dr, dc);
            }

            if (board[row][n - 1] == 'O' && !visited[row][n - 1]) {
                dfs(row, n - 1, visited, board, dr, dc);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
