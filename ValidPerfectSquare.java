// https://leetcode.com/problems/valid-perfect-square/

// TC -> O(log(n))
// SC -> O(1)

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int start = 2;
        int end = num / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            double d = (double) num / mid;

            if (mid == d) {
                return true;
            } else if (mid > d) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
