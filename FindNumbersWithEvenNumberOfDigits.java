package LeetCode;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumbersWithEvenNumberOfDigits {
    public boolean evenNumberDigits(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n /= 10;
        }

        return (count & 1) != 1;
    }

    public int findNumbers(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (evenNumberDigits(nums[i])) {
                total++;
            }
        }
        return total;
    }

    public int findNumbers_(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] > 9 && nums[i] < 100) || (nums[i] > 999 && nums[i] < 10000) || nums[i] == 100000) {
                count++;
            }
        }
        return count;
    }
}
