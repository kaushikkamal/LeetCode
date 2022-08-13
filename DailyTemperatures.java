// https://leetcode.com/problems/daily-temperatures/

// TC -> O(N)
// SC -> O(N)

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int index = s.pop();
                ans[index] = i - index;
            }
            s.push(i);
        }

        return ans;
    }

    public int[] dailyTemperatures_(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                s.pop();
            }

            ans[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }

        return ans;
    }
}
