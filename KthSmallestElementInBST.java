// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementInBST {

    // InOrder

    public int kthSmallest_(TreeNode root, int k) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (--k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        return 0;
    }

    // Morris Traversal (Not recommended)

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;

        while (root != null) {
            if (root.left == null) {
                count++;
                if (count == k) {
                    return root.val;
                }
                root = root.right;
            } else {
                TreeNode temp = root.left;

                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }

                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    count++;
                    if (count == k) {
                        return root.val;
                    }
                    temp.right = null;
                    root = root.right;
                }
            }
        }
        return count;
    }
}
