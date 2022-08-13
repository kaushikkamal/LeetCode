// https://leetcode.com/problems/validate-stack-sequences/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> s = new ArrayDeque<>();
        int i = 0;
        int n = popped.length;

        for (int num : pushed) {
            s.push(num);

            while (!s.isEmpty() && i < n && s.peek() == popped[i]) {
                s.pop();
                i++;
            }
        }

        return i == n;
    }

    public boolean validateStackSequences_(int[] pushed, int[] popped) {
        Deque<Integer> s = new ArrayDeque<>();

        int i = 0, j = 0;

        while (i < pushed.length && j < popped.length) {
            if (s.isEmpty() || s.peek() != popped[j]) {
                s.push(pushed[i]);
                i++;
            }

            if (s.peek() == popped[j]) {
                s.pop();
                j++;
            }
        }

        if (i == pushed.length) {
            while (!s.isEmpty() && j < popped.length) {
                if (s.pop() != popped[j]) {
                    return false;
                }
                j++;
            }
        }

        return i == pushed.length && j == popped.length;
    }
}
