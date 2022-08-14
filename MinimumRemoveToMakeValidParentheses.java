// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

package LeetCode;

public class MinimumRemoveToMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        int bal = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bal++;
            } else if (s.charAt(i) == ')') {
                bal--;
            }

            if (bal < 0) {
                bal = 0;
            } else {
                sb.append(s.charAt(i));
            }
        }

        if (bal == 0) {
            return sb.toString();
        }

        int i = sb.length() - 1;
        while (i >= 0 && bal > 0) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                bal--;
            }
            i--;
        }
        return sb.toString();
    }
}
