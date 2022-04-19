// https://leetcode.com/problems/number-of-lines-to-write-string/

package LeetCode;

import java.util.Arrays;

public class NumberOfLinesToWriteString {
    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int lineWidth = 0;
        for (int i = 0; i < s.length(); i++) {
            int w = widths[s.charAt(i) - 'a'];
            lineWidth += w;
            if (lineWidth > 100) {
                ++lines;
                lineWidth = w;
            }
        }

        return new int[] { lines, lineWidth };
    }

    public static void main(String[] args) {
        // int[] arr = { 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
        // 10, 10, 10, 10, 10, 10, 10, 10, 10,
        // 10 };
        int[] arr = { 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10 };
        String s = "bbbcccdddaaa";

        System.out.println(Arrays.toString(numberOfLines(arr, s)));

    }
}