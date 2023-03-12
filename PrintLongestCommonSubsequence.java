package LeetCode;

public class PrintLongestCommonSubsequence {
    public String printLongestCommonSubsequence(String text1, String text2) {
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

        int len = dp[n][m];
        char[] charArr = new char[len];
        int index = len - 1;
        int row = n, col = m;

        while (row > 0 && col > 0) {
            if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                charArr[index] = text1.charAt(row - 1);
                index--;
                row--;
                col--;
            } else {
                if (dp[row - 1][col] > dp[row][col - 1]) {
                    row = row - 1;
                } else {
                    col = col - 1;
                }
            }
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(new PrintLongestCommonSubsequence().printLongestCommonSubsequence("abcde", "bdgek"));
    }
}
