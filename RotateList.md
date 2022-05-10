https://leetcode.com/problems/rotate-list/

    package LeetCode;

    class RotateList {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null || head.next == null || k == 0) {
                return head;
            }
            
            ListNode cur = head;
            int len = 1;
            
            while(cur.next != null) {
                len++;
                cur = cur.next;
            }
            
            cur.next = head;
            k = len - k % len;
            
            while(k > 0) {
                k--;
                cur = cur.next;
            }
            
            head = cur.next;
            cur.next = null;
            
            return head;
        }
    }