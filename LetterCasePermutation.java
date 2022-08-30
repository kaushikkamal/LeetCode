// https://leetcode.com/problems/letter-case-permutation/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    private static void solve(String in, String op, int i, List<String> ans) {
        // base case

        if (op.length() == in.length()) {
            ans.add(op);
            return;
        }

        // main logic
        char cur = in.charAt(i);
        if (Character.isDigit(cur)) {
            solve(in, op + cur, i + 1, ans);
        } else {
            solve(in, op + Character.toLowerCase(cur), i + 1, ans);
            solve(in, op + Character.toUpperCase(cur), i + 1, ans);
        }
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, "", 0, ans);
        return ans;
    }
}
