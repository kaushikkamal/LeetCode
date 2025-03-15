package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarrayWithGivenXOR {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixXOR = 0;
        int count = 0;

        for (Integer num : A) {
            prefixXOR ^= num;

            if (prefixXOR == B) {
                count++;
            }

            if (map.containsKey(prefixXOR ^ B)) {
                count += map.get(prefixXOR ^ B);
            }

            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }

        return count;
    }
}
