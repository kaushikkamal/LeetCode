// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AmountOfTimeForBinaryTreeToBeInfected {
    private TreeNode makeParents(TreeNode root, HashMap<TreeNode, TreeNode> parents, int start) {
        if (root == null) {
            return null;
        }

        TreeNode source = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.val == start) {
                source = temp;
            }

            if (temp.left != null) {
                q.offer(temp.left);
                parents.put(temp.left, temp);
            }

            if (temp.right != null) {
                q.offer(temp.right);
                parents.put(temp.right, temp);
            }
        }

        return source;
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode source = makeParents(root, parents, start);
        if (source == null)
            return -1;

        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;

        q.offer(source);
        visited.add(source);

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            while (size-- > 0) {
                TreeNode temp = q.poll();

                if (temp.left != null && !visited.contains(temp.left)) {
                    q.offer(temp.left);
                    visited.add(temp.left);
                }

                if (temp.right != null && !visited.contains(temp.right)) {
                    q.offer(temp.right);
                    visited.add(temp.right);
                }

                if (parents.get(temp) != null && !visited.contains(parents.get(temp))) {
                    q.offer(parents.get(temp));
                    visited.add(parents.get(temp));
                }
            }
        }
        return level - 1;
    }
}
