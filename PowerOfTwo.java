// https://leetcode.com/problems/power-of-two/

package LeetCode;

public class PowerOfTwo {

    // bit manipulation
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    // recursive
    public boolean isPowerOfTwo_(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0 || (n & 1) == 1) {
            return false;
        }
        return isPowerOfTwo_(n / 2);
    }

    // iterative
    public boolean isPowerOfTwo__(int n) {
        if (n == 0) {
            return false;
        }

        while ((n % 2) == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
