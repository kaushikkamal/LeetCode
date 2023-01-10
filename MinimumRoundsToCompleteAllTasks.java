// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

package LeetCode;

import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        int numRounds = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : tasks) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int value : map.values()) {
            if (value == 1) {
                return -1;
            } else if (value == 2 || value == 3) {
                numRounds++;
            } else if (value % 3 == 0) {
                numRounds += value / 3;
            } else {
                numRounds += ((value / 3) + 1);
            }
        }

        return numRounds;
    }
}
