// https://leetcode.com/problems/gas-station/description/
package LeetCode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalDifference = 0;
        int totalCost = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            totalDifference += (gas[i] - cost[i]);
            totalCost += (gas[i] - cost[i]);

            if (totalCost < 0) {
                totalCost = 0;
                start = i + 1;
            }
        }

        if (totalDifference < 0) {
            return -1;
        }

        return start;
    }

    //! TLE
    public int canCompleteCircuit_(int[] gas, int[] cost) {
        int n = gas.length;

        for(int i = 0 ; i < n;i++) {
            int curIndex = i;
            int stopCounter = 0;
            int total = 0;

            while(stopCounter < n) {
                total += (gas[curIndex % n] - cost[curIndex % n]);
                if(total < 0) {
                    break;
                }
                stopCounter++;
                curIndex++;
            }
            if(stopCounter == n && total >= 0) {
                return i;
            }
        }
        return -1;
    }
}
