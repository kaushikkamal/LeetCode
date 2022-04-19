https://leetcode.com/problems/linked-list-cycle-ii/

    package DS.LeetCode;

    public class LinkedListCycleII {
        public ListNode detectCycle(ListNode head) {
            
            if(head == null){
                return null;
            }
                
            ListNode slow = head;
            ListNode fast = head;
            
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                
                if(slow == fast) {
                    slow = head;
                    
                    while(slow != fast){
                        slow = slow.next;
                        fast = fast.next;
                    }
                    
                    return slow;
                }
            }
            
            return null;
        }
    }
