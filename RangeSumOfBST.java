// https://leetcode.com/problems/range-sum-of-bst/

package LeetCode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        if (low <= root.val && root.val <= high) {
            return left + right + root.val;
        }
        return left + right;
    }
}
