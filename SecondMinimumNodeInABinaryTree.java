// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

package LeetCode;

class Item {
    int min;
    long ans;

    Item() {
    }

    Item(int min, long ans) {
        this.min = min;
        this.ans = ans;
    }
}

public class SecondMinimumNodeInABinaryTree {
    private void preorder(TreeNode root, Item item) {
        if (root == null) {
            return;
        }
        if (item.min < root.val && root.val < item.ans) {
            item.ans = root.val;
            return;
        }
        if (root.val == item.min) {
            preorder(root.left, item);
            preorder(root.right, item);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        Item item = new Item(root.val, Long.MAX_VALUE);

        preorder(root, item);

        return item.ans == Long.MAX_VALUE ? -1 : (int) item.ans;
    }
}
