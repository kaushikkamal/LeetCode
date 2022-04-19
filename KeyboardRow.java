package LeetCode;

// https://leetcode.com/problems/keyboard-row/
import java.util.ArrayList;
import java.util.Arrays;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        ArrayList<String> list1 = new ArrayList<String>(
                Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l"));
        ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("z", "x", "c", "v", "b", "n", "m"));

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            boolean first = false, second = false, third = false;
            for (int j = 0; j < words[i].length(); j++) {
                if (list1.contains(String.valueOf(words[i].charAt(j)).toLowerCase())) {
                    first = true;
                } else {
                    if (list2.contains(String.valueOf(words[i].charAt(j)).toLowerCase())) {
                        second = true;
                    } else {
                        if (list3.contains(String.valueOf(words[i].charAt(j)).toLowerCase())) {
                            third = true;
                        }
                    }
                }

            }

            if ((!first || !second) && (!second || !third) && (!third || !first)) {
                list.add(words[i]);
            }
        }

        String[] fin = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            fin[i] = list.get(i);
        }

        return fin;
    }
}
