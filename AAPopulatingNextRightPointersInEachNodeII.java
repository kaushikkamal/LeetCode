
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

public class AAPopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        // Techinique is we use BFS
        // We add first right child then left in the queue.
        // We are using one temp node with initially null value
        // after using element from queue we will add into the temp
        // when level change we will make temp null
        // TC O(n)
        // SC O(n)

        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node temp = null;
            while (size-- > 0) {
                Node head = queue.poll();
                head.next = temp;
                temp = head;
                if (head.right != null) {
                    queue.offer(head.right);
                }

                if (head.left != null) {
                    queue.offer(head.left);
                }
            }
        }
        return root;
    }
}
