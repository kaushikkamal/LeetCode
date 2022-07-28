https://leetcode.com/problems/partition-list/

    public class PartitionList {
        public ListNode partition(ListNode head, int x) {
            ListNode first = new ListNode();
            ListNode second = new ListNode();
            ListNode firstHead = first;
            ListNode secondHead = second;

            while (head != null) {
                if (head.val < x) {
                    first.next = head;
                    first = head;
                } else {
                    second.next = head;
                    second = head;
                }
                head = head.next;
            }

            second.next = null;
            first.next = secondHead.next;

            return firstHead.next;
        }
    }
