// https://leetcode.com/problems/sum-root-to-leaf-numbers/

package LeetCode;

public class SumRootToLeafNumbers {

    // optimal

    private int helper(TreeNode root, int res) {
        if (root == null) {
            return 0;
        }

        res = 10 * res + root.val;

        if (root.left == null && root.right == null) {
            return res;
        }

        int left = helper(root.left, res);
        int right = helper(root.right, res);

        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    // more space required

    private static void helper(TreeNode root, StringBuilder sb, int[] res) {
        if (root == null) {
            return;
        }

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            res[0] += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        helper(root.left, sb, res);
        helper(root.right, sb, res);

        sb.deleteCharAt(sb.length() - 1);
    }

    public static int sumNumbers_(TreeNode root) {
        int[] res = new int[1];
        StringBuilder sb = new StringBuilder();

        helper(root, sb, res);

        return res[0];
    }
}
