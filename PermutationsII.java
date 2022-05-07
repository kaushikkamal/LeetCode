package LeetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsII {
    public static void permu(int[] nums, List<Integer> single, List<List<Integer>> list, boolean[] check) {
        if (single.size() == nums.length && !list.contains(single)) {
            list.add(new ArrayList<>(single));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!check[i]) {
                check[i] = true;
                single.add(nums[i]);

                permu(nums, single, list, check);

                check[i] = false;
                single.remove(single.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        permu(nums, new ArrayList<>(), list, check);

        return list;
    }
}
