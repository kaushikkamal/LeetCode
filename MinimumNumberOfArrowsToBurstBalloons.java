// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/DFD

package LeetCode;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Arrays.sort(points, (a, b) -> a[1] - b[1]); not work
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int numArrows = 1;
        int shootPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= shootPosition) {
                continue;
            }
            numArrows++;
            shootPosition = points[i][1];
        }
        return numArrows;
    }
}
