package LeetCode;

// https://leetcode.com/problems/plus-one/
import java.util.*;

class PlusOne {
    public static int[] plusOne(int[] digits) {

        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }

    public static void main(String[] args) {
        // int[] num = {9, 8};
        int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        int[] ans = plusOne(num);
        System.out.println(Arrays.toString(ans));
    }
}