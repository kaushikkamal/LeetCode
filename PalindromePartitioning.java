// https://leetcode.com/problems/palindrome-partitioning/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

// ? TC: O((2^n)*k*(n/2))
// ? Reason:O(2^n)to generate every substring and O(n/2) to check if the substring generated is a palindrome. O(k)is for inserting the palindromes in another data structure, where k is the average length of the palindrome list.

// ? SC: O(k*x) 
// ? k is average length of each palindrome list, x is no of such palindrome list

public class PalindromePartitioning {
    private boolean isPalindrome(String temp) {
        int start = 0;
        int end = temp.length() - 1;

        while (start < end) {
            if (temp.charAt(start++) != temp.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private void solve(String s, int index, List<String> list, List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);

            if (isPalindrome(temp)) {
                list.add(temp);
                solve(s, i + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(s, 0, list, ans);

        return ans;
    }
}
