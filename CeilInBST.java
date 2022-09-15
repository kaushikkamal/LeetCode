// https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

package LeetCode;

public class CeilInBST {
    int findCeil(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }

        int res = -1;

        while (root != null) {
            if (root.val == key) {
                return root.val;
            } else if (root.val > key) {
                res = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
