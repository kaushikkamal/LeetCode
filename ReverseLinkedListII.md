// https://leetcode.com/problems/reverse-linked-list-ii/

    public class ReverseLinkedListII {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur = dummy;

            for (int i = 1; i < left; i++) {
                cur = cur.next;
            }

            int reverseTime = right - left + 1;
            ListNode prev = null;
            ListNode current = cur.next;

            while (current != null && reverseTime > 0) {
                ListNode next = current.next;
                current.next = prev;

                prev = current;
                current = next;
                reverseTime--;
            }

            cur.next = prev;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = current;
            
            return dummy.next;
        }
    }
