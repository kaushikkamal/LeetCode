package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

class BSTIterator {

    private Deque<TreeNode> s = new ArrayDeque<>();
    private boolean isReverse = true;

    BSTIterator() {
    }

    BSTIterator(TreeNode root, boolean reverse) {
        isReverse = reverse;
        pushAll(root);
    }

    public int next() {
        TreeNode temp = s.pop();
        if (isReverse) {
            pushAll(temp.left);
        } else {
            pushAll(temp.right);
        }
        return temp.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            s.push(node);
            if (isReverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

public class TwoSumIVInputIsABST {

    // TC -> O(N)
    // SC -> O(H) * 2

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j > k) {
                j = right.next();
            } else {
                i = left.next();
            }
        }
        return false;
    }

    // TC -> O(N)
    // SC -> O(N)

    private boolean check(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return check(root.left, set, k) || check(root.right, set, k);
    }

    public boolean findTarget_(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return check(root, set, k);
    }
}
