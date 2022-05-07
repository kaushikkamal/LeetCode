package LeetCode;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] one = new int[26];

        for (int i = 0; i < s.length(); i++) {
            one[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            one[t.charAt(i) - 'a']--;
        }

        for (int i : one) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
