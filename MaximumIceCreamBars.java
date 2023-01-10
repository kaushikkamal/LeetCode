// https://leetcode.com/problems/maximum-ice-cream-bars/description/

package LeetCode;

import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        int numIceCream = 0;

        Arrays.sort(costs);

        for (int eachCost : costs) {
            if (eachCost > coins) {
                break;
            }
            numIceCream++;
            coins -= eachCost;
        }
        return numIceCream;
    }
}
