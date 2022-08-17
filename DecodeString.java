// https://leetcode.com/problems/decode-string/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    static class Info {
        int count;
        int index;

        Info() {
        }

        Info(int c, int i) {
            this.count = c;
            this.index = i;
        }
    }

    public static String decodeString(String s) {
        Deque<Info> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int num = 0;

                while (Character.isDigit(s.charAt(idx))) {
                    num = 10 * num + (s.charAt(idx) - '0');
                    idx++;
                }

                st.push(new Info(num, sb.length()));
            } else if (Character.isAlphabetic(s.charAt(idx))) {
                sb.append(s.charAt(idx));
                idx++;
            } else if (s.charAt(idx) == '[') {
                idx++;
            } else {
                Info info = st.pop();
                int i = 0;
                String str = sb.substring(info.index).toString();
                String temp = "";
                int len = str.length();

                while (i < info.count) {
                    temp += str;
                    i++;
                }

                sb.replace(info.index, info.index + len, temp);
                idx++;
            }
        }
        return sb.toString();
    }
}
