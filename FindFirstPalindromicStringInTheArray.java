package LeetCode;

// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
public class FindFirstPalindromicStringInTheArray {
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for (String s : words) {
            if (isPalindrome(s)) {
                return s;
            }
        }
        return "";
    }
}
