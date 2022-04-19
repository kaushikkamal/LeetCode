package LeetCode;

// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
public class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        String str = "";

        for (String res : words) {
            str += res;

            if (s.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
