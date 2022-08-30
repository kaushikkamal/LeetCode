// https://leetcode.com/problems/generate-parentheses/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private void solve(int n, int opened, int closed, String op, List<String> ans) {
        if (n == opened && opened == closed) {
            ans.add(op);
            return;
        }

        if (closed > opened) {
            return;
        }

        if (opened + 1 <= n) {
            solve(n, opened + 1, closed, op + '(', ans);
        }

        if (closed + 1 <= n) {
            solve(n, opened, closed + 1, op + ')', ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve(n, 1, 0, "(", ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1 };

        for (int i : arr) {
            System.out.println(new GenerateParentheses().generateParenthesis(i));
        }
    }
}
