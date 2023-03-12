package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class PrintAllLongestCommonSubsequence {
    class Pair {
        int row, col;
        char[] charArr;
        int index;

        Pair() {
        }

        Pair(int r, int c, char[] tempArray, int i) {
            this.row = r;
            this.col = c;
            this.charArr = tempArray;
            this.index = i;
        }
    }

    public List<String> printLongestCommonSubsequence(String text1, String text2) {
        List<String> res = new ArrayList<>();
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        int len = dp[n][m];

        boolean[][] visited = new boolean[n + 1][m + 1];
        Deque<Pair> stack = new ArrayDeque<>();

        stack.push(new Pair(n, m, new char[len], len - 1));
        visited[n][m] = true;

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int row = p.row;
            int col = p.col;
            char[] charArr = p.charArr;
            int index = p.index;

            if (row == 0 || col == 0) {
                res.add(new String(charArr));
                continue;
            }

            if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                charArr[index] = text1.charAt(row - 1);
                index--;
                row--;
                col--;
                if (!visited[row][col]) {
                    stack.push(new Pair(row, col, charArr, index));
                    visited[row][col] = true;
                }
            } else {
                if (dp[row - 1][col] == dp[row][col - 1]) {
                    if (!visited[row - 1][col]) {
                        stack.push(new Pair(row - 1, col, charArr, index));
                        visited[row - 1][col] = true;
                    }
                    if (!visited[row][col - 1]) {
                        stack.push(new Pair(row, col - 1, charArr, index));
                        visited[row][col - 1] = true;
                    }
                } else if (dp[row - 1][col] < dp[row][col - 1]) {
                    if (!visited[row][col - 1]) {
                        stack.push(new Pair(row, col - 1, charArr, index));
                        visited[row][col - 1] = true;
                    }
                } else {
                    if (!visited[row - 1][col]) {
                        stack.push(new Pair(row - 1, col, charArr, index));
                        visited[row - 1][col] = true;
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public String printLongestCommonSubsequence_(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        StringBuilder sb = new StringBuilder();

        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                    sb.append(text1.charAt(i - 1));
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }
            prev = cur;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PrintAllLongestCommonSubsequence().printLongestCommonSubsequence("abcde", "bdgek"));
        System.out.println(new PrintAllLongestCommonSubsequence().printLongestCommonSubsequence("abaaa", "baabaca"));
        // System.out.println(new
        // PrintLongestCommonSubsequence().printLongestCommonSubsequence("abcde",
        // "bdgek"));
    }
}
