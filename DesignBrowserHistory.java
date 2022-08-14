// https://leetcode.com/problems/design-browser-history/

// TC -> O(n)
// SC -> O(1)
package LeetCode;

public class DesignBrowserHistory {
    public class Node {
        String url;
        Node prev, next;

        public Node() {
        }

        public Node(String u) {
            this.url = u;
            prev = null;
            next = null;
        }
    }

    Node head, cur;

    public DesignBrowserHistory(String homepage) {
        head = new Node(homepage);
        cur = head;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        cur.next = newNode;
        newNode.prev = cur;
        cur = newNode;
    }

    public String back(int steps) {
        while (cur.prev != null && steps > 0) {
            cur = cur.prev;
            steps--;
        }
        return cur.url;
    }

    public String forward(int steps) {
        while (cur.next != null && steps > 0) {
            cur = cur.next;
            steps--;
        }
        return cur.url;
    }
}
