// https://leetcode.com/problems/longest-repeating-character-replacement/
package LeetCode;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int start = 0;
        int mostFreqElementCount = 0;
        int res = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            freq[ch - 'A']++;
            mostFreqElementCount = Math.max(mostFreqElementCount, freq[ch - 'A']);

            int numberOfCharacterToBeReplaced = end - start + 1 - mostFreqElementCount;
            if (numberOfCharacterToBeReplaced > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }

            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
