// https://www.codingninjas.com/codestudio/problems/bottom-view-of-binary-tree_893110

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Node {
        BinaryTreeNode node;
        int row;

        Node() {
        }

        Node(BinaryTreeNode node, int row) {
            this.node = node;
            this.row = row;
        }
    }

    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        // Write your code here.
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        q.offer(new Node(root, 0));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int row = temp.row;

            map.put(row, temp.node.val);

            if (temp.node.left != null) {
                q.offer(new Node(temp.node.left, row - 1));
            }
            if (temp.node.right != null) {
                q.offer(new Node(temp.node.right, row + 1));
            }
        }

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            ans.add(mp.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        System.out.println(bottomView(root));
    }
}
