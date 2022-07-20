// https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275

package LeetCode;

import java.util.*;

public class SortStack {
    public static void sortInsertStack(Stack<Integer> s, int top) {
        if (s.isEmpty() || top > s.peek()) {
            s.push(top);
            return;
        }
        int temp = s.pop();
        sortInsertStack(s, top);
        s.push(temp);
    }

    public static void sortStack(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int top = s.pop();
            sortStack(s);
            sortInsertStack(s, top);
        }
    }
}