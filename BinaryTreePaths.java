// https://leetcode.com/problems/binary-tree-paths/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    private void helper(TreeNode root, List<String> ans, String op) {
        if (root.left == null && root.right == null) {
            ans.add(op + root.val);
            return;
        }

        if (root.left != null) {
            helper(root.left, ans, op + root.val + "->");
        }

        if (root.right != null) {
            helper(root.right, ans, op + root.val + "->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        helper(root, ans, "");

        return ans;
    }
}
