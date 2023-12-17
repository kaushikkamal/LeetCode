// https://leetcode.com/problems/word-search/description/

package LeetCode;

public class WordSearch {
    private boolean dfs(char[][] board, String word, int M, int N, int[] dr, int[] dc, int row, int col,
            boolean[][] visited, int index) {
        if (index == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newRow = row + dr[dir];
            int newCol = col + dc[dir];

            if (newRow >= 0 && newRow < M && newCol >= 0 && newCol < N && !visited[newRow][newCol]
                    && board[newRow][newCol] == word.charAt(index + 1)) {
                if (dfs(board, word, M, N, dr, dc, newRow, newCol, visited, index + 1)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        boolean[][] visited = new boolean[M][N];

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, M, N, dr, dc, row, col, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
