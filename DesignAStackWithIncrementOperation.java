// https://leetcode.com/problems/design-a-stack-with-increment-operation/

// TC -> O(N)
// SC -> O(N)

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignAStackWithIncrementOperation {
    Deque<Integer> s;
    int size = 0;

    public DesignAStackWithIncrementOperation(int maxSize) {
        s = new ArrayDeque<>();
        size = maxSize;
    }

    public void push(int x) {
        if (s.size() >= size) {
            return;
        }

        s.push(x);
    }

    public int pop() {
        if (s.size() == 0) {
            return -1;
        }

        return s.pop();
    }

    public void increment(int k, int val) {
        Deque<Integer> temp = new ArrayDeque<>();

        while (!s.isEmpty()) {
            temp.push(s.pop());
        }

        while (!temp.isEmpty()) {
            if (k > 0) {
                s.push(val + temp.pop());
                k--;
            } else {
                s.push(temp.pop());
            }
        }
    }
}
