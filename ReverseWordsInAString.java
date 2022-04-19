package LeetCode;

// https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] str = s.trim().split(" ");

        for (int i = 0; i < str.length / 2; i++) {
            String temp = str[i];
            str[i] = str[str.length - i - 1];
            str[str.length - i - 1] = temp;
        }

        String res = "";
        for (String i : str) {
            res += i;
            res += " ";
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
