// https://leetcode.com/problems/linked-list-components/

    public class LinkedListComponents {
        public int numComponents(ListNode head, int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }

            ListNode temp = head;
            int res = 0;

            while (temp != null) {
                if (set.contains(temp.val) && (temp.next == null || !set.contains(temp.next.val))) {
                    res++;
                }
                temp = temp.next;
            }
            return res;
        }
    }
