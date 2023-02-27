// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/

package LeetCode;

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        boolean isLowOdd = (low % 2) == 1;
        boolean isHighOdd = (high % 2) == 1;

        if (isLowOdd || isHighOdd) {
            return (high - low) / 2 + 1;
        }
        return (high - low) / 2;
    }
}
