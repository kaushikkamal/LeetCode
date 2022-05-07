package LeetCode;

// https://leetcode.com/problems/combination-sum/
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void combination(int index, int[] candidates, int target, List<List<Integer>> list,
            List<Integer> singleList) {
        if (index == candidates.length) {
            if (target == 0) {
                list.add(new ArrayList<>(singleList));
            }
            return;
        }

        if (target >= candidates[index]) {
            singleList.add(candidates[index]);
            combination(index, candidates, target - candidates[index], list, singleList);
            singleList.remove(singleList.size() - 1);
        }
        combination(index + 1, candidates, target, list, singleList);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> singleList = new ArrayList<>();

        combination(0, candidates, target, list, singleList);

        return list;
    }
}
