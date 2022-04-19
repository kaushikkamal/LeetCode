https://leetcode.com/problems/sort-list/
   
    package DS.LeetCode;

    public class SortList {
        private static ListNode midPoint(ListNode head) {
            ListNode midPrev = null;
            
            while(head != null && head.next != null){
                midPrev = (midPrev == null) ? head : midPrev.next;
                head = head.next.next;
            }
            
            ListNode mid = midPrev.next;
            midPrev.next = null;
            
            return mid;
        }
        
        private static ListNode mergeList(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode temp = head;
            
            while(list1 != null && list2 != null) {
                if(list1.val <= list2.val) {
                    temp.next = list1;
                    temp = temp.next;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    temp = temp.next;
                    list2 = list2.next;
                }
            }
            
            temp.next = (list1 != null) ? list1 : list2;
            return head.next; 
        }
        
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            
            ListNode mid = midPoint(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            
            return mergeList(left,right);
            
        }
    }
