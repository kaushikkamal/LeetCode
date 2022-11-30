// https://leetcode.com/problems/odd-string-difference/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OddStringDifference {
    public String oddString(String[] words) {
        HashMap<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            char[] ch = words[i].toCharArray();

            for (int j = 0; j < ch.length - 1; j++) {
                list.add(ch[j + 1] - ch[j]);
            }

            if (map.containsKey(list)) {
                map.get(list).add(words[i]);
            } else {
                ArrayList<String> listS = new ArrayList<>(Arrays.asList(words[i]));
                map.put(list, listS);
            }
        }

        for (Map.Entry<ArrayList<Integer>, ArrayList<String>> mp : map.entrySet()) {
            if (mp.getValue().size() == 1) {
                return mp.getValue().get(0);
            }
        }
        return "";
    }
}
