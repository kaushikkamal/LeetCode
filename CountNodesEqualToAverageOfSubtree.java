// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

package LeetCode;

class Item {
    int sum;
    int num;
    int count;

    Item() {
    }

    Item(int sum, int num, int c) {
        this.sum = sum;
        this.num = num;
        this.count = c;
    }
}

public class CountNodesEqualToAverageOfSubtree {
    private Item helper(TreeNode root) {

        if (root == null) {
            return new Item(0, 0, 0);
        }

        Item left = helper(root.left);
        Item right = helper(root.right);

        int totalSum = root.val + left.sum + right.sum;
        int totalNum = 1 + left.num + right.num;

        if ((totalSum / totalNum) == root.val) {
            return new Item(totalSum, totalNum, left.count + right.count + 1);
        }
        return new Item(totalSum, totalNum, left.count + right.count);
    }

    public int averageOfSubtree(TreeNode root) {
        Item res = helper(root);
        return res.count;
    }
}
