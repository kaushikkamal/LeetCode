// https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1

package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayContainingAtMostTwoDistinctIntegers {

    public int totalElements(Integer[] arr) {
        int start = 0;
        int maxLength = 0;
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int end = 0; end < n; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (start <= end && map.size() > 2) {
                map.put(arr[start], map.getOrDefault(arr[start], 1) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
