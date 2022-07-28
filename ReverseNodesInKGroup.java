// https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseNodesInKGroup {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = head, prev = dummy, next = dummy;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }

        while (count >= k) {
            cur = prev.next;
            next = cur.next;

            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;

                prev.next = next;
                next = cur.next;
            }

            prev = cur;
            count -= k;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        print(head);
        ListNode newHead = reverseKGroup(head, 3);
        print(newHead);
    }
}
