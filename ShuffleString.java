package LeetCode;

// https://leetcode.com/problems/shuffle-string/
public class ShuffleString {
    
    // 1 ms 45 MB
    public String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = s.charAt(i);
        }

        return String.valueOf(result);
    }

    // 2 ms 44.7 MB
    // public String restoreString(String s, int[] indices) {
    // StringBuilder sb = new StringBuilder(s);

    // for (int i = 0; i < s.length(); i++) {
    // sb.setCharAt(indices[i], s.charAt(i));
    // }

    // return sb.toString();
    // }
}