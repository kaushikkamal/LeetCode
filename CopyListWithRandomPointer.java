// https://leetcode.com/problems/copy-list-with-random-pointer/

package LeetCode;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // create deepy copy nodes and insert them in after the orginal nodes.

        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // assign the random pointers of the deep copied nodes

        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        // seperate the original and deep copy nodes.

        Node newHead = new Node(0);
        Node dummy = newHead;

        temp = head;

        while (temp != null) {
            Node fast = temp.next.next;

            dummy.next = temp.next;
            temp.next = fast;
            dummy = dummy.next;
            temp = fast;
        }

        return newHead.next;
    }

    public Node copyRandomList_(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;

        // made the duplicate of each node
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        // link the next and random pointer
        temp = head;

        while (temp != null) {
            Node node = map.get(temp);
            node.next = temp.next == null ? null : map.get(temp.next);
            node.random = temp.random == null ? null : map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }
}
