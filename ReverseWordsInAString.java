// https://leetcode.com/problems/reverse-words-in-a-string/

package LeetCode;

import java.util.ArrayList;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i] + " ");
        }

        return sb.toString().trim();
    }

    public String reverseWords_(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = str.length - 1; i > 0; i--) {
            sb.append(str[i] + " ");
        }

        return sb.toString() + str[0];
    }

    public static String reverseWords__(String s) {
        ArrayList<String> arr = new ArrayList<>();
        StringBuilder eachWord = new StringBuilder();

        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                eachWord.append(ch);
            } else {
                if (eachWord.length() != 0) {
                    arr.add(eachWord.toString());
                }
                eachWord.setLength(0);
            }
        }

        arr.add(eachWord.toString());

        int n = arr.size();

        for (int i = 0; i < n / 2; i++) {
            String temp = arr.get(i);
            arr.set(i, arr.get(n - 1 - i));
            arr.set(n - 1 - i, temp);
        }

        eachWord.setLength(0);
        for (String each : arr) {
            eachWord.append(each);
            eachWord.append(" ");
        }

        return eachWord.toString().trim();
    }
}
