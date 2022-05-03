package LeetCode;

// https://leetcode.com/problems/di-string-match/
public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int low = 0;
        int high = s.length();
        int[] arr = new int[high + 1];
        int j = 0;

        for (char c : s.toCharArray()) {
            if (c == 'I') {
                arr[j] = low;
                low++;
            } else {
                arr[j] = high;
                high--;
            }
            j++;
        }

        if ((s.length() & 1) == 0) {
            arr[j] = low;
        } else {
            arr[j] = high;
        }

        return arr;
    }
}
