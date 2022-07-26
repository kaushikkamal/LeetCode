https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

    package LeetCode;

    import java.util.Stack;

    public class ConvertBinaryNumberInALinkedListToInteger {
        public int getDecimalValue(ListNode head) {
            int ans = 0;
            ListNode temp = head;
            
            while(temp != null) {
                ans = (ans * 2) + temp.val;
                temp = temp.next;
            }
            return ans;
        }

        public static int getDecimalValue_(ListNode head) {
            int ans = 0;
            ListNode temp = head;

            Stack<Integer> st = new Stack<>();

            while (temp != null) {
                st.push(temp.val);
                temp = temp.next;
            }
            int i = 0;
            while (!st.isEmpty()) {
                ans += (st.peek() * Math.pow(2, i));
                i++;
                st.pop();
            }
            return ans;
        }
    }
