package LeetCode;

// https://leetcode.com/problems/kth-distinct-string-in-an-array
import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                k--;
                if (k == 0) {
                    return m.getKey();
                }
            }
        }
        return "";
    }
}
