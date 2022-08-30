// https://leetcode.com/problems/ransom-note/

package LeetCode;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
