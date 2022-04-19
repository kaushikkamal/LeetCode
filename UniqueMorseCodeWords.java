package LeetCode;

import java.util.HashSet;

// https://leetcode.com/problems/unique-morse-code-words/
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hs = new HashSet<>();

        String[] arr = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        for (int i = 0; i < words.length; i++) {
            String temp = "";
            for (int j = 0; j < words[i].length(); j++) {
                temp += arr[words[i].charAt(j) - 'a'];
            }
            hs.add(temp);
        }

        return hs.size();
    }
}
