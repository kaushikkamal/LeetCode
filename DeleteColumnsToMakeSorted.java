package LeetCode;

// https://leetcode.com/problems/delete-columns-to-make-sorted/
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int j = 0;
        int c = 0;

        while (j < strs[0].length()) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    c++;
                    break;
                }
            }
            j++;
        }
        return c;
    }
}
