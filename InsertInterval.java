package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        List<int[]> res = new ArrayList<>();
        boolean isAdded = false;

        // newInterval is added to intervals
        for (int[] eachInterval : intervals) {
            if (!isAdded && eachInterval[0] > newInterval[0]) {
                res.add(newInterval);
                isAdded = true;
            }
            res.add(eachInterval);
        }
        if (!isAdded) {
            res.add(newInterval);
        }

        // merge the intervals

        int start = res.get(0)[0];
        int end = res.get(0)[1];

        List<int[]> mergeIntervalList = new ArrayList<>();

        for (int[] eachInterval : res) {
            if (end >= eachInterval[0]) {
                end = Math.max(end, eachInterval[1]);
            } else {
                mergeIntervalList.add(new int[] { start, end });
                start = eachInterval[0];
                end = eachInterval[1];
            }
        }

        mergeIntervalList.add(new int[] { start, end });

        return mergeIntervalList.toArray(new int[mergeIntervalList.size()][]);

    }
}
