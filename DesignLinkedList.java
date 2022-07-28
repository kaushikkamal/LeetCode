// https://leetcode.com/problems/design-linked-list

public class DesignLinkedList {
    int length;
    Node head;

    class Node {
        Node(int x) {
            this.val = x;
            this.next = null;
        }

        int val;
        Node next;
    }

    public DesignLinkedList() {
        this.length = 0;
        this.head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= this.length) {
            return -1;
        }

        int c = 0;
        Node cur = head;

        while (c != index) {
            cur = cur.next;
            c++;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node newNode = new Node(val);
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public void addAtTail(int val) {
        if (this.length == 0) {
            addAtHead(val);
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        Node newNode = new Node(val);
        cur.next = newNode;
        this.length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.length) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == this.length) {
            addAtTail(val);
            return;
        }

        Node cur = head;
        int c = 0;

        while (c != index - 1) {
            c++;
            cur = cur.next;
        }

        Node newNode = new Node(val);
        newNode.next = cur.next;
        cur.next = newNode;
        this.length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.length) {
            return;
        }

        if (index == 0) {
            head = head.next;
            this.length--;
            return;
        }
        
        Node cur = head;
        Node prev = null;
        int c = 0;

        while (c != index) {
            c++;
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        cur.next = null;
        this.length--;
    }
}
