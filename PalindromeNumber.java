package LeetCode;

// https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int n1 = x;
        int temp = 0;

        while (n1 > 0) {
            temp = temp * 10 + n1 % 10;
            n1 /= 10;
        }
        return x == temp;
    }
}
