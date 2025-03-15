// https://leetcode.com/problems/longest-common-prefix/

package LeetCode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int prefixLength = prefix.length();

        for (int i = 1; i < strs.length; i++) {
            while (prefixLength > strs[i].length() || !prefix.equals(strs[i].substring(0, prefixLength))) {
                prefixLength--;

                if (prefixLength == 0) {
                    return "";
                }

                prefix = prefix.substring(0, prefixLength);
            }
        }

        return prefix;
    }

    public String longestCommonPrefix_(String[] str) {
        int index = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i].length() < str[index].length()) {
                index = i;
            }
        }

        String temp = str[index];

        for (String s : str) {
            while (s.indexOf(temp) != 0) {
                temp = temp.substring(0, temp.length() - 1);
            }
        }

        return temp;
    }
}
