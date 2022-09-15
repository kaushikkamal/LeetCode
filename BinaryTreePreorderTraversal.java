// https://leetcode.com/problems/binary-tree-preorder-traversal/

package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {

    // ? Morris Traversal

    public List<Integer> preorderTraversal__(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;

                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    temp.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }

    // ? Recursive

    private void preOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);

        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preOrder(root, ans);

        return ans;
    }

    // ? Iterative

    public List<Integer> preorderTraversal_(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();

        if (root == null) {
            return ans;
        }

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            ans.add(temp.val);

            if (temp.right != null) {
                st.push(temp.right);
            }

            if (temp.left != null) {
                st.push(temp.left);
            }
        }

        return ans;
    }
}