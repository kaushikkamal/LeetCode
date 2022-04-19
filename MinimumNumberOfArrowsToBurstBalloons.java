package LeetCode;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int max = points[0][1];

        int c = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > max) {
                c++;
                max = points[i][1];
            } else {
                max = Math.max(max,points[i][1]);
            }
        }

        return c;
    }

    public static void main(String[] args) {
        // int[][] points = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(findMinArrowShots(points));
    }
}
