package LeetCode;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public int reverse(int x) {
        int sum = 0;
        int multi = 1;
        if (x < 0) {
            multi = -1;
            x = multi * x;
        }

        while (x > 0) {
            if ((sum * multi) > Integer.MAX_VALUE / 10 || (sum * multi) < Integer.MIN_VALUE / 10) {
                return 0;
            }
            sum = sum * 10 + (x % 10);
            x /= 10;
        }

        return sum * multi;
    }
}
