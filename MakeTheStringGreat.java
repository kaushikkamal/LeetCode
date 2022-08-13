// https://leetcode.com/problems/make-the-string-great/

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && Math.abs(st.peek() - s.charAt(i)) == 32) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        char[] ans = new char[st.size()];
        int index = st.size() - 1;

        while (!st.isEmpty()) {
            ans[index--] = st.pop();
        }

        return new String(ans);
    }
}
