// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNode {

    private void helper(Node root) {
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        helper(root.left);
        helper(root.right);
    }

    public Node connect(Node root) {
        helper(root);

        return root;
    }

    // TC -> O(N)
    // SC -> O(N)

    public Node connect_(Node root) {
        if (root == null)
            return null;

        Node cur = root;

        Queue<Node> q = new LinkedList<>();
        q.offer(cur);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (i == size - 1) {
                    temp.next = null;
                } else {
                    temp.next = q.peek();
                }

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }
        return root;
    }
}
