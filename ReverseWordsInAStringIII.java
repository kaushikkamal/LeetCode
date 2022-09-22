// https://leetcode.com/problems/reverse-words-in-a-string-iii/

package LeetCode;

public class ReverseWordsInAStringIII {
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                sb.insert(0, s.charAt(i));
            } else {
                res.append(sb);
                res.append(" ");
                sb.setLength(0);
            }
            i++;
        }
        res.append(sb);
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String[] arr = { "Let's take LeetCode contest", "God Ding" };
        for (String s : arr) {
            System.out.println(reverseWords(s));
        }
    }
}
