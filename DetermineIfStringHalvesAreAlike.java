// https://leetcode.com/problems/determine-if-string-halves-are-alike/description/

package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int countVowels = 0;
        HashSet<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (set.contains(s.charAt(start))) {
                ++countVowels;
            }
            if (set.contains(s.charAt(end))) {
                --countVowels;
            }
            start++;
            end--;
        }

        return countVowels == 0;
    }
}
