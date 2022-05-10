package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

    // TC -> O(N) // don't need the left to travel complete array
    // SC -> O(N) // where N is the size of HashSet taken for storing the elements

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                if (left < map.get(s.charAt(right)) + 1) {
                    left = map.get(s.charAt(right)) + 1;
                }
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // TC -> O(2*N) // sometimes left and right both have to travel complete array
    // SC -> O(N) // where N is the size of HashSet taken for storing the elements

    public static int lengthOfLongestSubstring_(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (set.contains(ch)) {
                while (left < right && set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(ch);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
