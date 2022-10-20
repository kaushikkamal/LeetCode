// https://practice.geeksforgeeks.org/problems/largest-bst/1

package LeetCode;

class Item {
    int size;
    int max;
    int min;

    Item(int size, int max, int min) {
        this.size = size;
        this.max = max;
        this.min = min;
    }
}

public class LargestBSTinBT {

    private static Item postorder(TreeNode node) {
        if (node == null) {
            return new Item(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Item left = postorder(node.left);
        Item right = postorder(node.right);

        if (left.max < node.val && node.val < right.min) {
            return new Item(1 + left.size + right.size, Math.max(node.val, right.max), Math.min(node.val, left.min));
        }

        return new Item(Math.max(left.size, right.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    static int largestBst(TreeNode root) {
        Item res = postorder(root);
        return res.size;
    }
}
