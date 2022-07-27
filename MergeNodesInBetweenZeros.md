// https://leetcode.com/problems/merge-nodes-in-between-zeros/

    // TC -> O(N)
    // SC -> O(1)

    public class MergeNodesInBetweenZeros {
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;

            int sum = 0;
            head = head.next;

            while (head != null) {
                if (head.val == 0) {
                    cur.next = new ListNode(sum);
                    cur = cur.next;
                    sum = 0;
                } else {
                    sum += head.val;
                }
                head = head.next;
            }

            return dummy.next;
        }
    }
