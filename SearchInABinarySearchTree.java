// https://leetcode.com/problems/search-in-a-binary-search-tree/

package LeetCode;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        
        while (cur != null) {
            if (val == cur.val) {
                return cur;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
}
