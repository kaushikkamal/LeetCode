// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AllNodesDistanceKInBinaryTree {

    private static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left != null) {
                q.offer(temp.left);
                parentMap.put(temp.left, temp);
            }

            if (temp.right != null) {
                q.offer(temp.right);
                parentMap.put(temp.right, temp);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        int level = 0;

        q.offer(target);
        visited.add(target);

        while (!q.isEmpty()) {
            int size = q.size();

            if (level == k) {
                break;
            }

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

                if (parentMap.containsKey(temp) && !visited.contains(parentMap.get(temp))) {
                    q.offer(parentMap.get(temp));
                    visited.add(parentMap.get(temp));
                }
            }
        }

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(distanceK(root, root.left, 2));
    }
}
