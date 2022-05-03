https://leetcode.com/problems/reverse-linked-list/

## Iterative way
    class ReverseLinkedList {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode cur = head;
            ListNode prev = null;

            while(cur != null) {
                ListNode next = cur.next;
                
                cur.next = prev;
                prev = cur;
                cur = next;
            }        
            return prev;
        }
    }

## Recursive way

    public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            
            ListNode newHead = reverseList(head.next);
            ListNode headNext = head.next;
            headNext.next = head;
            head.next = null;
            
            return newHead;    
    }
