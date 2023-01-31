// https://www.codingninjas.com/codestudio/problems/house-robber_839733?leftPanelTab=0

package LeetCode;

import java.util.ArrayList;

public class HouseRobberII {
    private static long calculate(int n, ArrayList<Integer> nums) {
        long prev2 = nums.get(0);
        long prev1 = nums.get(0);

        for (int i = 1; i < n; i++) {
            long picked = nums.get(i);
            if (i > 1) {
                picked += prev2;
            }
            long notPicked = prev1;
            long cur = Math.max(picked, notPicked);

            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

    public static long houseRobber(int[] valueInHouse) {
        if (valueInHouse.length == 1) {
            return (long) valueInHouse[0];
        }

        int n = valueInHouse.length;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1.add(valueInHouse[i]);
            }
            if (i != n - 1) {
                temp2.add(valueInHouse[i]);
            }
        }

        return Math.max(calculate(n - 1, temp1), calculate(n - 1, temp2));
    }
}
