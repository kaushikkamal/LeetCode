// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

import java.util.ArrayList;
import java.util.Collections;

public class MaximumTwinSumOfALinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // TC -> O(n)
    // SC -> O(1)

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode p = head;
        ListNode midNode = mid(head);
        ListNode q = reverse(midNode.next);
        int ans = 0;

        midNode.next = null;

        while (p != null && q != null) {
            ans = Math.max(ans, p.val + q.val);
            p = p.next;
            q = q.next;
        }

        return ans;
    }

    // TC -> O(n)
    // SC -> O(n)

    public static int pairSum_(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            list.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        int len = list.size() - 1;

        while (slow != null) {
            list.set(len, list.get(len) + slow.val);
            len--;
            slow = slow.next;
        }

        return Collections.max(list);
    }
}
