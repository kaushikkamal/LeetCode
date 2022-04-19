package LeetCode;

import java.util.HashMap;

// https://leetcode.com/problems/count-common-words-with-one-occurrence/
public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (String s : words1) {
            if (map1.containsKey(s)) {
                map1.put(s, -1);
            } else {
                map1.put(s, 1);
            }
        }

        for (String s : words2) {
            if (map2.containsKey(s)) {
                map2.put(s, -1);
            } else {
                map2.put(s, 1);
            }
        }

        int c = 0;

        for (String s : words2) {
            if (map1.containsKey(s) && map1.get(s) == 1 && map2.get(s) == 1) {
                c++;
            }
        }
        return c;
    }
}
