// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

package LeetCode;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
