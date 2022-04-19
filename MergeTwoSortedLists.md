https://leetcode.com/problems/merge-two-sorted-lists/

    package DS.LeetCode;

    public class MergeTwoSortedLists {
        
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            
            ListNode head = new ListNode();
            ListNode cur = head;
            
            while(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }
            }
            
            cur.next = (list1 != null) ? list1 : list2;
            return head.next;
        }
    }
