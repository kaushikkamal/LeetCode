https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    TC -> O(n)
    SC -> O(1)

    public class RemoveDuplicatesFromSortedListII {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();

            dummy.next = head;

            ListNode cur = dummy;

            while (head != null) {
                if (head.next != null && head.val == head.next.val) {
                    while (head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                    cur.next = head.next;
                } else {
                    cur.next = head;
                    cur = cur.next;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
