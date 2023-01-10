// https://leetcode.com/problems/unique-number-of-occurrences/description/

package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if (!set.add(mp.getValue())) {
                return false;
            }
        }
        return true;
    }
}
