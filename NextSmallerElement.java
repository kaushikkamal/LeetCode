// https://www.codingninjas.com/codestudio/problems/1112581

package LeetCode;

import java.util.*;

public class NextSmallerElement {

    // TC -> O(N)
    // SC -> O(N)

    static void reverse(ArrayList<Integer> list) {
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            Collections.swap(list, i, j);
            i++;
            j--;
        }
    }

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {

        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>(arr.size());

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                list.add(-1);
                s.push(arr.get(i));
            } else {
                while (!s.isEmpty() && arr.get(i) <= s.peek()) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(s.peek());
                }
                s.push(arr.get(i));
            }
        }
        reverse(list);
        return list;
    }
}
