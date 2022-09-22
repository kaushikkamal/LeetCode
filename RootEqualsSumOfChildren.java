// https://leetcode.com/problems/root-equals-sum-of-children/

package LeetCode;

public class RootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
