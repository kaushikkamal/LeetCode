// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

package LeetCode;

public class SumOfNodesWithEvenValuedGrandparent {

    private void helper(TreeNode current, TreeNode parent, TreeNode grandParent, int[] count) {
        if (current == null)
            return;

        if (grandParent != null && (grandParent.val & 1) == 0) {
            count[0] += current.val;
        }

        helper(current.left, current, parent, count);
        helper(current.right, current, parent, count);
    }

    public int sumEvenGrandparent(TreeNode root) {
        int[] count = new int[] { 0 };

        helper(root, null, null, count);

        return count[0];
    }

    public int sumEvenGrandparent_(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;

        if ((root.val & 1) == 0) {
            if (root.left != null && root.left.left != null) {
                ans += root.left.left.val;
            }
            if (root.left != null && root.left.right != null) {
                ans += root.left.right.val;
            }
            if (root.right != null && root.right.left != null) {
                ans += root.right.left.val;
            }
            if (root.right != null && root.right.right != null) {
                ans += root.right.right.val;
            }
        }

        return ans + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}
