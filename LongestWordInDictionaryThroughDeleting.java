
package LeetCode;
// https://leetcode.com/problems/longest-word-in-dictionary
import java.util.*;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b) -> {
            int diff = b.length() - a.length();

            return diff == 0 ? a.compareTo(b) : diff;
        });

        int idx = -1;

        for (String str : dictionary) {
            int i;
            for (i = 0; i < str.length(); i++) {
                idx = s.indexOf(str.charAt(i), idx + 1);
                if (idx == -1) {
                    break;
                }
            }

            if (i == str.length()) {
                return str;
            }
        }
        return "";
    }
}
