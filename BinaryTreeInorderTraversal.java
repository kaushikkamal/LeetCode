// https://leetcode.com/problems/binary-tree-inorder-traversal/

package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {

    // ? Morris Traversal

    public List<Integer> inorderTraversal__(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;

                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    inorder.add(cur.val);
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }

    // ? recursive

    public static void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        inOrder(root, ans);

        return ans;
    }

    // ? Iterative

    public List<Integer> inorderTraversal_(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            ans.add(temp.val);
            temp = temp.right;
        }

        return ans;
    }
}
