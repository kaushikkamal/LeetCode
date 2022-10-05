// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    // Recursive

    private void helper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null)
            return;

        if (level >= ans.size()) {
            ans.add(0, new LinkedList<>());
        }

        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);

        ans.get(ans.size() - level - 1).add(root.val);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        int level = 0;

        helper(root, level, ans);

        return ans;
    }

    // Iterative

    public List<List<Integer>> levelOrderBottom_(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();

            while (size-- > 0) {
                TreeNode temp = q.poll();
                list.add(temp.val);

                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }

            ans.add(0, list);
        }
        return ans;
    }
}
