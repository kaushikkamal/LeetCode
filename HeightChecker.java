package LeetCode;

import java.util.Arrays;

// https://leetcode.com/problems/height-checker/
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] sortedHeight = heights.clone();
        int c = 0;

        Arrays.sort(sortedHeight);
        
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedHeight[i]) {
                c++;
            }
        }
        return c;
    }
}
