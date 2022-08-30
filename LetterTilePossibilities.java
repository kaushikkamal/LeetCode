// https://leetcode.com/problems/letter-tile-possibilities/

package LeetCode;

public class LetterTilePossibilities {
    private static int solve(int[] freq) {
        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] <= 0) {
                continue;
            }
            count++;
            freq[i]--;
            count += solve(freq);
            freq[i]++;
        }
        return count;
    }

    public static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return solve(freq);
    }
}
