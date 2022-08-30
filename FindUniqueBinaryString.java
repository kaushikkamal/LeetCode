// https://leetcode.com/problems/find-unique-binary-string/

package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class FindUniqueBinaryString {

    // ? Cantor's Diagonalization

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append((nums[i].charAt(i) == '0') ? "1" : "0");
        }
        return sb.toString();
    }

    // ? Brute Force

    private void solve(int n, String op, ArrayList<String> ans) {
        // base case

        if (n == 0) {
            ans.add(op);
            return;
        }

        // main logic

        solve(n - 1, op + "0", ans);

        solve(n - 1, op + "1", ans);
    }

    public String findDifferentBinaryString_(String[] nums) {
        HashSet<String> set = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();
        int n = nums.length;

        for (String s : nums) {
            set.add(s);
        }

        solve(n, "", ans);

        for (String s : ans) {
            if (!set.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
