package LeetCode;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicatesInStringII {

    public static String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        int[] count = new int[n];
        char[] res = s.toCharArray();

        for (int j = 0; j < n; j++, i++) {
            res[i] = res[j];
            count[i] = (i > 0 && res[i - 1] == res[j]) ? count[i - 1] + 1 : 1;
            if (count[i] >= k) {
                i -= k;
            }
        }
        return new String(res, 0, i);
    }

    // public static String removeDuplicates(String s, int k) {
    //     StringBuilder sb = new StringBuilder();
    //     int[] count = new int[s.length()];

    //     for (char ch : s.toCharArray()) {
    //         sb.append(ch);
    //         int last = sb.length() - 1;

    //         count[last] = (last > 0 && sb.charAt(last) == sb.charAt(last - 1)) ? count[last - 1] + 1 : 1;

    //         if (count[last] >= k) {
    //             sb.delete(sb.length() - k, sb.length());
    //         }
    //     }
    //     return sb.toString();
    // }
}
