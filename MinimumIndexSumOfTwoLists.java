package LeetCode;

import java.util.*;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int max = Integer.MAX_VALUE;
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) && map.get(list2[i]) + i < max) {
                list.clear();
                list.add(list2[i]);
                max = map.get(list2[i]) + i;
            } else if (map.containsKey(list2[i]) && map.get(list2[i]) + i == max) {
                list.add(list2[i]);
            }
        }

        String[] res = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
