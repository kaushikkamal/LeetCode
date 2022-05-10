// https://leetcode.com/problems/combination-sum-iii/

package LeetCode;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));
    }

    private static void solve(int k, int n, int index, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == k && n == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i <= 9; i++) {
            cur.add(i);
            solve(k, n - i, i + 1, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        solve(k, n, 1, cur, ans);
        return ans;
    }
}
