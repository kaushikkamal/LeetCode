package LeetCode;

// https://leetcode.com/problems/unique-morse-code-words/
import java.util.HashSet;

public class UniqueMorseRepresentations {
    public static int uniqueMorseRepresentations(String[] words) {
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

    public static void main(String[] args) {
        String[] words = { "gin", "zen", "gig", "msg" };

        System.out.println(uniqueMorseRepresentations(words));
    }
}
