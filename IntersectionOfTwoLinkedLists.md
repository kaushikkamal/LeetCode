https://leetcode.com/problems/intersection-of-two-linked-lists/

    package LeetCode;

    public class IntersectionOfTwoLinkedLists {
        
        // TC -> O(2M)
        // SC -> O(1)

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode d1 = headA;
            ListNode d2 = headB;

            while (d1 != d2) {
                d1 = (d1 == null) ? headB : d1.next;
                d2 = (d2 == null) ? headA : d2.next;
            }

            return d1;
        }
    }
