// https://leetcode.com/problems/length-of-last-word/
package LeetCode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] str = s.trim().split(" ");
        return str[str.length - 1].length();
    }
}
