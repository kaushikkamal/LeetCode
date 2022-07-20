// https://www.interviewbit.com/problems/nearest-smaller-element/

package LeetCode;

import java.util.*;

public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {
        int[] res = new int[A.length];
        Arrays.fill(res, -1);

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            while (!s.isEmpty() && A[i] <= s.peek()) {
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i] = s.peek();
            }
            s.push(A[i]);
        }
        return res;
    }
}
