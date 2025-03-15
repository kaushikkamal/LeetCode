package LeetCode;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
    static public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int n = intervals.length;

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastEnd) {
                lastEnd = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 2, 3 }, { 3, 5 }, { 2, 6 }, { 4, 7 }, { 5, 9 } };

        System.out.println(eraseOverlapIntervals(intervals));
    }
}
