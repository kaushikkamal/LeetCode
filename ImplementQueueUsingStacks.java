// https://leetcode.com/problems/implement-queue-using-stacks/

package LeetCode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> s;

    public ImplementQueueUsingStacks() {
        s = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            s.push(x);
            return;
        }
        int top = s.pop();
        push(x);
        s.push(top);
    }

    public int pop() {
        return empty() ? -1 : s.pop();
    }

    public int peek() {
        return empty() ? -1 : s.peek();
    }

    public boolean empty() {
        return s.isEmpty();
    }
}
