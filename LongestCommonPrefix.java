package LeetCode;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
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
