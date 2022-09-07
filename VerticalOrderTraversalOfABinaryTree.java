// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {
    static class TreeNode {

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

    static class Node {
        TreeNode node;
        int row, col;

        Node() {
        }

        Node(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> res = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(root, 0, 0));

        while (!q.isEmpty()) {

            Node temp = q.poll();
            int row = temp.row;
            int col = temp.col;

            res.putIfAbsent(row, new TreeMap<>());

            res.get(row).putIfAbsent(col, new PriorityQueue<>());

            res.get(row).get(col).offer(temp.node.val);

            if (temp.node.left != null) {
                q.offer(new Node(temp.node.left, row - 1, col + 1));
            }

            if (temp.node.right != null) {
                q.offer(new Node(temp.node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : res.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) { // ? each priority queue
                while (!pq.isEmpty()) { // ? each item in priority queue
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        System.out.println(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(root));
    }
}
