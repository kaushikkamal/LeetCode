// https://leetcode.com/problems/min-stack/

// TC -> O(1)
// SC -> O(N)

package LeetCode;

import java.util.Stack;

public class MinStack {
    Stack<Long> s;
    Long min;

    public MinStack() {
        s = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if (s.isEmpty()) {
            s.push(value);
            min = value;
        } else if (value >= min) {
            s.push(value);
        } else {
            s.push(2 * value - min);
            min = value;
        }
    }

    public void pop() {
        if (s.isEmpty()) {
            return;
        }
        if (s.peek() >= min) {
            s.pop();
            return;
        }
        min = 2 * min - s.pop();
    }

    public int top() {
        if (s.isEmpty()) {
            return -1;
        }
        Long val = s.peek();
        if (val < min) {
            return min.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        if (s.isEmpty()) {
            return -1;
        }
        return min.intValue();
    }
}
