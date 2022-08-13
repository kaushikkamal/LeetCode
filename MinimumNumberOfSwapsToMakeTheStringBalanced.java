// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

package LeetCode;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public int minSwaps(String s) {
        int bal = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                bal++;
            } else {
                if (bal > 0) {
                    bal--;
                }
            }
        }

        return (bal + 1) / 2;
    }

    public static int minSwaps_(String s) {
        int bal = 0;
        int swaps = 0;
        int j = s.length() - 1;

        for (int i = 0; i <= j; i++) {
            if (s.charAt(i) == '[') {
                bal++;
            } else {
                bal--;
            }

            if (bal < 0) {
                while (i < j && s.charAt(j) != '[') {
                    j--;
                }
                j--;
                bal = 1;
                swaps++;
            }
        }

        return swaps;
    }
}
