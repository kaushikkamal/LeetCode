// https://leetcode.com/problems/sqrtx/

// TC -> O(log(n))
// SC -> O(1)

public class SqrtOfX {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid <= x / mid) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
