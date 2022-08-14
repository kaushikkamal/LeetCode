// https://leetcode.com/problems/largest-rectangle-in-histogram/
package LeetCode;

import java.util.Stack;

// TC -> O(N)
// SC -> O(N)

public class LargestRectangleInHistogram {
    private static int[] nearestSmallerRight(int[] heights, int size) {
        int[] res = new int[size];
        Stack<Integer> s = new Stack<>();

        for (int i = size - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? size : s.peek();
            s.push(i);
        }
        return res;
    }

    private static int[] nearestSmallerLeft(int[] heights, int size) {
        int[] res = new int[size];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < size; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] NSR, NSL;
        int size = heights.length;

        NSR = nearestSmallerRight(heights, size);
        NSL = nearestSmallerLeft(heights, size);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            max = Math.max(max, heights[i] * (NSR[i] - NSL[i] - 1));
        }
        return max;
    }
}
