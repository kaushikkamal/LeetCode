package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> s = new ArrayDeque<>();

        for (String c : ops) {
            if (c.equals("C")) {
                s.pop();
            } else if (c.equals("D")) {
                s.push(2 * s.peek());
            } else if (c.equals("+")) {
                int top = s.pop();
                int newNum = top + s.peek();
                s.push(top);
                s.push(newNum);
            } else {
                s.push(Integer.valueOf(c));
            }
        }

        int ans = 0;

        for (int score : s) {
            ans += score;
        }

        return ans;
    }
}
