// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty

package LeetCode;

import java.util.HashMap;

public class MinimumNumberOfOperationsToMakeArrayEmpty {

    private int dividedByTwoResult(int num) {
        int rem = num % 2;

        if (rem == 1) {
            return -1;
        }

        return num / 2;
    }

    private int dividedByThreeResult(int num) {
        int rem = num % 3;

        if (rem == 0) {
            return num / 3;
        }

        return num / 3 + 1;
    }

    public int minOperations(int[] nums) {
        int numOfOperationsRequired = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int value : map.values()) {
            if (value == 1) {
                return -1;
            }

            int dividedByTwo = dividedByTwoResult(value);
            int dividedByThree = dividedByThreeResult(value);

            if (dividedByTwo == -1 && dividedByThree == -1) {
                return -1;
            }

            int operationRequired = Math.min(dividedByTwo, dividedByThree) == -1
                    ? Math.max(dividedByTwo, dividedByThree)
                    : Math.min(dividedByTwo, dividedByThree);

            numOfOperationsRequired += operationRequired;
        }

        return numOfOperationsRequired;
    }

    public static void main(String[] args) {
        int[] nums = { 14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12 };
        System.out.println(new MinimumNumberOfOperationsToMakeArrayEmpty().minOperations(nums));
    }
}
