package LeetCode;

// https://leetcode.com/problems/permutations/
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void solve(int[] nums, List<List<Integer>> allList, List<Integer> list, boolean[] check) {

        if (list.size() == nums.length) {
            allList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true;
                list.add(nums[i]);

                solve(nums, allList, list, check);

                list.remove(list.size() - 1);
                check[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allAns = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        solve(nums, allAns, list, check);
        return allAns;
    }
}
