// https://leetcode.com/problems/minimum-distance-between-bst-nodes//

package LeetCode;

class Item {
    int prev;
    int min;

    Item() {
    }

    Item(int prev, int min) {
        this.prev = prev;
        this.min = min;
    }
}

public class MinimumDistanceBetweenBSTNodes {
    private void inorder(TreeNode root, Item item) {
        if (root == null)
            return;

        inorder(root.left, item);

        if (item.prev != -1) {
            item.min = Math.min(item.min, root.val - item.prev);
        }

        item.prev = root.val;

        inorder(root.right, item);
    }

    public int minDiffInBST(TreeNode root) {
        Item item = new Item(-1, Integer.MAX_VALUE);

        inorder(root, item);

        return item.min;
    }
}
