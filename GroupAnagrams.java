// https://leetcode.com/problems/group-anagrams/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] charArr = new int[26];

            for (char c : str.toCharArray()) {
                charArr[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(charArr[i]);
            }

            String res = sb.toString();
            System.out.println(res);

            map.putIfAbsent(res, new ArrayList<>());
            map.get(res).add(str);
        }

        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams_(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String res = new String(charArr);

            map.putIfAbsent(res, new ArrayList<>());
            map.get(res).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams__(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> mapResult = new HashMap<>();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> mp : treeMap.entrySet()) {
                sb.append(mp.getKey());
                sb.append(mp.getValue());
            }

            mapResult.putIfAbsent(sb.toString(), new ArrayList<>());
            List<String> temp = mapResult.get(sb.toString());
            temp.add(str);
            mapResult.put(sb.toString(), temp);
            treeMap.clear();
        }

        for (Map.Entry<String, List<String>> mp : mapResult.entrySet()) {
            result.add(mp.getValue());
        }

        return result;
    }

    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(new GroupAnagrams().groupAnagrams(str));
    }
}
