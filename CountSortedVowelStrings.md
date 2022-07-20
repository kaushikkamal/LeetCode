https://leetcode.com/problems/count-sorted-vowel-strings/

    package LeetCode;

    import java.util.ArrayList;

    public class CountSortedVowelStrings {

        // TC -> O(nk)
        // SC -> O(nk)
        // k = 5

        public static int countVowelStrings(int n) {
            int[][] dp = new int[n + 1][6];
            for (int i = 1; i <= n; ++i) {
                for (int k = 1; k <= 5; ++k) {
                    dp[i][k] = dp[i][k - 1] + (i > 1 ? dp[i - 1][k] : 1);
                }
            }
            return dp[n][5];
        }

        /*
        * number of combonations with repetions :
        * k + n − 1                (k + n - 1) !
        *           C        = ---------------------
        *             n            n ! * (k - 1) !
        * 
        * here k = 5, so
        *                         (n+4) * (n+3) * (n+2) * (n+1)
        *                    = ---------------------------------------
        *                                    24
        */

        // TC -> O(1)
        // SC -> O(1)

        public static int countVowelStrings_(int n) {
            return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
        }

        // TC -> O(N!)

        private static void count(int n, int index, String[] map, ArrayList<String> cur, ArrayList<ArrayList<String>> ans) {
            if (cur.size() == n) {
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i = index; i < map.length; i++) {
                cur.add(map[i]);
                count(n, i, map, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }

        public static int countVowelStrings__(int n) {
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            String[] map = { "a", "e", "i", "o", "u" };
            count(n, 0, map, new ArrayList<>(), ans);
            System.out.println(ans);
            return ans.size();
        }
    }