package LeetCode;

// https://leetcode.com/problems/shortest-completing-word/

public class ShortestCompletingWord {

    static boolean check(String s, int[] map) {
        int[] temp = new int[26];
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                temp[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (temp[i] < map[i]) {
                return false;
            }
        }
        return true;
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        String newStr = "";
        int[] map = new int[26];
        String res = "";

        licensePlate = licensePlate.toLowerCase();

        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                newStr += c;
                map[c - 'a']++;
            }
        }

        for (String s : words) {
            if (newStr.length() <= s.length() && check(s, map)) {
                if (res == "") {
                    res = s;
                } else if (s.length() < res.length()) {
                    res = s;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String licensePlate = "iMSlpe4";
        String[] words = { "claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought",
                "use" };
        System.out.println(shortestCompletingWord(licensePlate, words));
    }
}
