// https://leetcode.com/problems/maximum-units-on-a-truck/

package LeetCode;

import java.util.Arrays;

class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int weightConsumed = 0;
        int totalUnits = 0;

        int index = 0;
        while (index < boxTypes.length && weightConsumed < truckSize) {
            int[] boxType = boxTypes[index];

            if (weightConsumed + boxType[0] <= truckSize) {
                weightConsumed += boxType[0];
                totalUnits += (boxType[0] * boxType[1]);
            } else {
                int consumableBox = truckSize - weightConsumed;
                weightConsumed += consumableBox;
                totalUnits += (consumableBox * boxType[1]);
            }

            index++;
        }
        return totalUnits;
    }
}