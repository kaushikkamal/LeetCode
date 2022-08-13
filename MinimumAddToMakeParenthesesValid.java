// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

// TC -> O(N)
// SC -> O(1)

package LeetCode;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int bal = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                bal++;
            } else {
                bal--;
            }

            if (bal < 0) {
                count++;
                bal++;
            }
        }

        return count + bal;
    }
}
