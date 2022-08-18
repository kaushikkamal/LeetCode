// https://leetcode.com/problems/permutations-ii/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static void permu(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] check) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !check[i - 1]) {
                continue;
            }

            if (!check[i]) {
                check[i] = true;

                list.add(nums[i]);
                permu(nums, list, ans, check);
                list.remove(list.size() - 1);

                check[i] = false;
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        permu(nums, new ArrayList<>(), ans, check);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> list = permuteUnique(nums);
        System.out.println(list);
    }
}
