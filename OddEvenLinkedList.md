// https://leetcode.com/problems/odd-even-linked-list/

    public class OddEvenLinkedList {
        public ListNode oddEvenList(ListNode head) {
            
            if(head == null || head.next == null) {
                return head;
            }
        
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            
            while(even !=null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            
            odd.next = evenHead;
            
            return head;  
        }

        public ListNode oddEvenList_(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }

            ListNode oddCur = new ListNode();
            ListNode evenCur = new ListNode();

            ListNode odd = oddCur;
            ListNode even = evenCur;

            boolean isOdd = true;

            while (head != null) {
                if (isOdd) {
                    oddCur.next = new ListNode(head.val);
                    oddCur = oddCur.next;
                } else {
                    evenCur.next = new ListNode(head.val);
                    evenCur = evenCur.next;
                }

                isOdd = !isOdd;
                head = head.next;
            }

            oddCur.next = even.next;

            return odd.next;
        }
    }
