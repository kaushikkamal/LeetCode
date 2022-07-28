https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 
    public class SwappingNodesInALinkedList {
        public ListNode swapNodes(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode first = head;
            ListNode firstPrev = null;
            ListNode last = head;
            ListNode lastPrev = null;
            ListNode cur = head;

            int count = 0;

            while (cur != null) {
                count++;
                cur = cur.next;
            }

            for (int i = 1; i < k; i++) {
                firstPrev = first;
                first = first.next;
            }

            for (int i = 1; i < (count - k + 1); i++) {
                lastPrev = last;
                last = last.next;
            }

            if (firstPrev != null) {
                firstPrev.next = last;
            } else {
                head = last;
            }

            if (lastPrev != null) {
                lastPrev.next = first;
            } else {
                head = first;
            }

            ListNode temp = first.next;
            first.next = last.next;
            last.next = temp;

            return head;
        }

        // values are swapped not nodes

        public ListNode swapNodes_(ListNode head, int k) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode first = head;

            for (int i = 1; i < k; i++) {
                fast = fast.next;
            }
            first = fast;

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            int temp = first.val;
            first.val = slow.val;
            slow.val = temp;

            return head;
        }
    }
