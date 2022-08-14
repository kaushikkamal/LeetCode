// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    // TC -> O(N)
    // SC -> O(N)

    public String reverseParentheses(String s) {
        int n = s.length();
        int[] arr = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        // 1st pass
        // get the position of respective parentheses and store in the array

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                int temp = st.pop();
                arr[i] = temp;
                arr[temp] = i;
            }
        }

        // 2nd pass
        // if ( or ) is get, then change the i and d
        // i is current index and d is direction

        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = arr[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // TC -> O(N*N)
    // SC -> O(N)

    private void reverse(StringBuilder sb, int index) {
        int start = index;
        int end = sb.length() - 1;

        while (start <= end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
    }

    public String reverseParentheses_(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(sb.length());
            } else if (c == ')') {
                int index = st.pop();
                reverse(sb, index);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
