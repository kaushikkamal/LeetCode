// https://leetcode.com/problems/combination-sum-ii/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private void combi(int[] arr, int index, List<Integer> list, List<List<Integer>> ans, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // if(index < arr.length && arr[index] > target) {
        // return;
        // }

        for (int i = index; i < arr.length; i++) {

            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                return;
            }

            list.add(arr[i]);
            combi(arr, i + 1, list, ans, target - arr[i]);
            list.remove(list.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        combi(candidates, 0, new ArrayList<>(), ans, target);

        return ans;
    }
}
