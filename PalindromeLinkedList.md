https://leetcode.com/problems/palindrome-linked-list/

    public class PalindromeLinkedList {
        public static ListNode midPoint(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public static ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode prevNode = null;
            ListNode currNode = head;

            while (currNode != null) {
                ListNode nextNode = currNode.next;
                currNode.next = prevNode;

                prevNode = currNode;
                currNode = nextNode;
            }
            return prevNode;
        }

        public boolean isPalindrome(ListNode head) {
            ListNode mid = midPoint(head);
            ListNode firstHalf = head;
            ListNode secondHalf = reverse(mid);

            while (firstHalf != null && secondHalf != null) {
                if (firstHalf.val != secondHalf.val) {
                    break;
                }
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }

            return firstHalf == null || secondHalf == null;
        }
    }
