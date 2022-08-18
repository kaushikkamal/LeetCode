// https://leetcode.com/problems/combination-sum/
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private void combination(int[] arr, int i, List<Integer> list,
            List<List<Integer>> ans, int target) {

        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (i == arr.length) {
            return;
        }

        if (target >= arr[i]) {
            list.add(arr[i]);
            combination(arr, i, list, ans, target - arr[i]);
            list.remove(list.size() - 1);
        }

        combination(arr, i + 1, list, ans, target);
    }

    // private void combination(int[] arr, int index, List<Integer> list,
    // List<List<Integer>> ans, int target) {

    // // base case
    // if (target == 0) {
    // ans.add(new ArrayList<>(list));
    // return;
    // }

    // for (int i = index; i < arr.length; i++) {
    // if (target < arr[i]) {
    // return;
    // }

    // list.add(arr[i]);
    // combination(arr, i, list, ans, target - arr[i]);
    // list.remove(list.size() - 1);
    // }
    // }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combination(candidates, 0, new ArrayList<>(), ans, target);

        return ans;
    }
}
