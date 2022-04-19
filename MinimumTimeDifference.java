package LeetCode;

import java.util.List;

// https://leetcode.com/problems/minimum-time-difference/
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        boolean[] map = new boolean[24 * 60]; // 1440

        for (String s : timePoints) {
            String[] arr = s.split(":");
            int hour = Integer.parseInt(arr[0]);
            int min = Integer.parseInt(arr[1]);

            if (map[hour * 60 + min]) {
                return 0;
            }
            map[hour * 60 + min] = true;
        }

        int first = -1;
        int prev = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 1440; i++) {
            if (map[i]) {
                if (first == -1) {
                    first = i;
                    prev = i;
                } else {
                    min = Math.min(min, Math.min(i - prev, 1440 - first + prev));
                    prev = i;
                }
            }
        }

        min = Math.min(min, Math.min(prev - first, 1440 - prev + first)); // check the first and the last one

        return min;
    }
}
