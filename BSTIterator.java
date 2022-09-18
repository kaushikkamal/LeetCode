// https://leetcode.com/problems/binary-search-tree-iterator/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    Deque<TreeNode> s = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = s.pop();
        int res = temp.val;

        temp = temp.right;

        while (temp != null) {
            s.push(temp);
            temp = temp.left;
        }

        return res;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}
