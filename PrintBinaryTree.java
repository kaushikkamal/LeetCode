// https://leetcode.com/problems/print-binary-tree/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {
    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return 1 + Math.max(left, right);
    }

    private void setValue(TreeNode root, List<List<String>> ans, int level, int row, int start, int end) {
        if (level >= row || root == null) {
            return;
        }

        int mid = start + (end - start) / 2;
        ans.get(level).set(mid, Integer.toString(root.val));

        setValue(root.left, ans, level + 1, row, start, mid - 1);
        setValue(root.right, ans, level + 1, row, mid + 1, end);
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();

        int row = getHeight(root);
        int col = (int) Math.pow(2, row) - 1;

        for (int i = 0; i < row; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add("");
            }
            ans.add(list);
        }

        setValue(root, ans, 0, row, 0, col - 1);

        return ans;
    }
}
