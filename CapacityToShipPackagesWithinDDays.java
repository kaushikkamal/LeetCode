// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

// Time complexity: O(n * log(SIZE)), where SIZE is the size of the search space (sum of weights - max weight).
// Space complexity: O(1).

public class CapacityToShipPackagesWithinDDays {
    public int getRequiredDays(int[] weights, int days, int minimumDays) {
        int weightSum = 0;
        int daysRequired = 1;

        for (int i : weights) {
            weightSum += i;
            if (weightSum > minimumDays) {
                weightSum = i;
                daysRequired++;
            }
        }
        return daysRequired;
    }

    public int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;

        for (int i : weights) {
            start = Math.max(start, i);
            end += i;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int requiredDays = getRequiredDays(weights, days, mid);

            if (requiredDays <= days) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
