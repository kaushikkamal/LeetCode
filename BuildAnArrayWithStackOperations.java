// https://leetcode.com/problems/build-an-array-with-stack-operations/

package LeetCode;

import java.util.ArrayList;

public class BuildAnArrayWithStackOperations {
    public ArrayList<String> buildArray(int[] target, int n) {
        ArrayList<String> list = new ArrayList<>();
        int i = 1, j = 0;

        while (i <= n && j < target.length) {
            list.add("Push");
            if (i == target[j]) {
                i++;
                j++;
            } else if (i < target[j]) {
                list.add("Pop");
                i++;
            }
        }
        return list;
    }
}
