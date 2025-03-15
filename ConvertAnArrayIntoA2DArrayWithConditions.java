package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!map.isEmpty()) {
            List<Integer> singleRow = new ArrayList<>();

            for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
                int key = mp.getKey();
                singleRow.add(key);

                map.put(key, map.get(key) - 1);

                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }

            result.add(new ArrayList<>(singleRow));
        }
        return result;
    }
}