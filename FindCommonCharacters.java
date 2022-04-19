package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// https://leetcode.com/problems/find-common-characters/
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : words[0].toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 1; i < words.length; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();

            for (char c : words[i].toCharArray()) {
                if (temp.containsKey(c)) {
                    temp.put(c, temp.get(c) + 1);
                } else {
                    temp.put(c, 1);
                }
            }

            HashMap<Character, Integer> union = new HashMap<>();

            for (Map.Entry<Character, Integer> m : temp.entrySet()) {
                if (map.containsKey(m.getKey())) {
                    union.put(m.getKey(), Math.min(map.get(m.getKey()), m.getValue()));
                }
            }

            map = union;
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            for (int i = 1; i <= m.getValue(); i++) {
                list.add(m.getKey().toString());
            }
        }
        return list;
    }
}
