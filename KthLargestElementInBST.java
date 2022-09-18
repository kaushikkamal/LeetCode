package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthLargestElementInBST {

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.right;
            }
            cur = s.pop();
            if (--k == 0) {
                return cur.val;
            }
            cur = cur.left;
        }
        return 0;
    }
}
