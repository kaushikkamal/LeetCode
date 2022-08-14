https://leetcode.com/problems/first-bad-version/

TC -> O(log(n))

SC -> O(1)

    package LeetCode; 

    public class FirstBadVersion {
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            int firstBad = -1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (isBadVersion(mid)) {
                    firstBad = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return firstBad;
        }
    }
