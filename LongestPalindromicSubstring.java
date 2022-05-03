package LeetCode;

// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    private boolean isPlaindrome(String temp) {
        int i, j;
        i = 0;
        j = temp.length() - 1;

        while (i < j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        String res = "";
        int len = res.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, j + 1);
                if (isPlaindrome(temp) && temp.length() > len) {
                    res = temp;
                    len = temp.length();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaabbaa";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }
}
