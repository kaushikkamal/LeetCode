// https://leetcode.com/problems/palindromic-substrings/    

package LeetCode;

public class PalindromicSubstrings {
    private int expandCenter(String s, int start, int end) {
        int count = 0;

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandCenter(s, i, i);
            count += expandCenter(s, i, i + 1);
        }

        return count;
    }
}
