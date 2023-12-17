// https://leetcode.com/problems/merge-k-sorted-lists/description/
package LeetCode;

import java.util.PriorityQueue;

import LeetCode.HelperClasses.ListNode;

public class MergeKSortedLists {

    // TC -> O(K + K * log(N))
    // SC -> O(K)

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null) {
                pq.offer(tail.next);
            }
        }

        return head.next;
    }

    // TC -> O(K * N*K)
    // SC -> O()

    public ListNode mergeKLists_(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int k = lists.length;
        int minIdx = -1;
        int val = Integer.MAX_VALUE;

        while (true) {
            for (int i = 0; i < k; i++) {
                if (lists[i] != null && lists[i].val < val) {
                    val = lists[i].val;
                    minIdx = i;
                }
            }

            // every index is pointing to NULL
            if (minIdx == -1) {
                break;
            }

            // creating the node
            temp.next = new ListNode(lists[minIdx].val);
            temp = temp.next;
            lists[minIdx] = lists[minIdx].next;

            // reset the variables
            minIdx = -1;
            val = Integer.MAX_VALUE;
        }
        return head.next;
    }
}
