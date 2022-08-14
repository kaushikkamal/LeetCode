// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static void solve(String digits, int index, String[] map, StringBuilder op, List<String> res) {
        if (index >= digits.length()) {
            res.add(op.toString());
            return;
        }

        int val = digits.charAt(index) - '0';
        String str = map[val];

        for (int i = 0; i < str.length(); i++) {
            op.append(str.charAt(i));
            solve(digits, index + 1, map, op, res);
            op.deleteCharAt(op.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == "") {
            return res;
        }
        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        StringBuilder op = new StringBuilder();

        solve(digits, 0, map, op, res);

        return res;
    }
}
