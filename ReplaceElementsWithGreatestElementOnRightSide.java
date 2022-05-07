package LeetCode;

// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                temp = Math.max(temp, arr[j]);
            }
            arr[i] = temp;
        }
        arr[arr.length - 1] = -1;

        return arr;
    }
}
