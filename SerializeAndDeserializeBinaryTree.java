// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                sb.append("N ");
                continue;
            }

            sb.append(temp.val + " ");

            q.offer(temp.left);
            q.offer(temp.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        String[] s = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));

        q.offer(root);

        for (int i = 1; i < s.length; i++) {
            TreeNode temp = q.poll();

            if (!s[i].equals("N")) {
                temp.left = new TreeNode(Integer.parseInt(s[i]));
                q.offer(temp.left);
            }

            i++;

            if (!s[i].equals("N")) {
                temp.right = new TreeNode(Integer.parseInt(s[i]));
                q.offer(temp.right);
            }
        }

        return root;
    }
}
