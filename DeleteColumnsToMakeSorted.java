// https://leetcode.com/problems/delete-columns-to-make-sorted/
package LeetCode;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int j = 0;
        int n = strs[0].length();

        while (j < n) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break;
                }
            }

            j++;
        }
        return count;
    }
}
