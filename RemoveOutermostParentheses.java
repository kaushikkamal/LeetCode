// https://leetcode.com/problems/remove-outermost-parentheses/

package LeetCode;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String str) {
        StringBuilder sb = new StringBuilder("");
        int opened = 0;

        for (char c : str.toCharArray()) {
            if (c == '(' && opened++ > 0) {
                sb.append(c);
            } else if (c == ')' && opened-- > 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses_(String s) {
        StringBuilder sb = new StringBuilder("");
        int start = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }

            if (open == close) {
                sb.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
