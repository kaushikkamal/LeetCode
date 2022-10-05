// https://leetcode.com/problems/path-sum-ii/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    private void helper(TreeNode root, int target, List<Integer> list, List<List<Integer>> ans) {
        if (root == null)
            return;

        list.add(root.val);

        if (root.left == null && root.right == null) {
            if (target == root.val) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (root.left != null) {
            helper(root.left, target - root.val, list, ans);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helper(root.right, target - root.val, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
}
