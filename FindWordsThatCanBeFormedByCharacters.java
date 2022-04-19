
package LeetCode;

// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        int len = 0;

        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }

        for (String s : words) {
            int[] temp = new int[26];
            boolean flag = false;

            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (temp[i] > map[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                len += s.length();
            }
        }

        return len;
    }
}
