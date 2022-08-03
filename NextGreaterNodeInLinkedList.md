https://leetcode.com/problems/next-greater-node-in-linked-list/

    public class NextGreaterNodeInLinkedList {
        public int[] nextLargerNodes(ListNode head) {
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> s = new Stack<>();

            ListNode temp = head;
            while (temp != null) {
                list.add(temp.val);
                temp = temp.next;
            }

            int[] res = new int[list.size()];

            for (int i = list.size() - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek() <= list.get(i)) {
                    s.pop();
                }

                res[i] = s.isEmpty() ? 0 : s.peek();
                s.push(list.get(i));
            }
            return res;
        }
    }
