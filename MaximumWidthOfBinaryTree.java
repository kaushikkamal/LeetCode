// https://leetcode.com/problems/maximum-width-of-binary-tree/

package LeetCode;

import java.util.LinkedList;
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

class Node {
    TreeNode node;
    int index;

    Node() {
    }

    Node(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int width = 0;
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int prevIndex = q.peek().index;
            int right = 0;

            while (size-- > 0) {
                Node temp = q.poll();
                right = temp.index;

                if (temp.node.left != null) {
                    q.offer(new Node(temp.node.left, 2 * (right - prevIndex) + 1));
                }

                if (temp.node.right != null) {
                    q.offer(new Node(temp.node.right, 2 * (right - prevIndex) + 2));
                }
            }

            width = Math.max(width, right - prevIndex + 1);
        }
        return width;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(root));
    }
}
