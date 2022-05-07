package LeetCode;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.trim();
        String temp = "";

        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                temp += c;
            }
        }

        temp = temp.toLowerCase();
        int n = temp.length();

        if (n == 0 || n == 1) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (temp.charAt(i) != temp.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
