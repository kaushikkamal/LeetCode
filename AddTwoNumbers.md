https://leetcode.com/problems/add-two-numbers/    
    
    package LeetCode;

    public class AddTwoNumbers {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode();
            ListNode cur = dummyHead;

            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;

                int sum = carry + x + y;
                carry = sum / 10;

                cur.next = new ListNode(sum % 10);
                cur = cur.next;

                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            if(carry>0){
                cur.next = new ListNode(carry);
            }

            return dummyHead.next;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode cur = head;
            
            int rem = 0;
            while(l1 != null && l2 != null) {
                int temp = rem + l1.val + l2.val;
                
                if(temp>9){
                    temp %= 10;
                    rem = 1;
                } else {
                    rem = 0;
                }
                
                cur.next = new ListNode(temp);
                cur = cur.next;
                
                l1 = l1.next;
                l2 = l2.next;
            }
            
            while(l1 != null) {
                int temp = rem + l1.val;
                if(temp>9){
                    temp %= 10;
                    rem = 1;
                } else {
                    rem = 0;
                }
                cur.next = new ListNode(temp);
                cur = cur.next;
                l1 = l1.next;
            }
            
            while(l2 != null) {
                int temp = rem + l2.val;
                if(temp>9){
                    temp %= 10;
                    rem = 1;
                } else {
                    rem = 0;
                }
                cur.next = new ListNode(temp);
                cur = cur.next;
                l2 = l2.next;
            }
            
            if(rem == 1){
                cur.next = new ListNode(1);
            }
            return head.next;   
        }
    }
