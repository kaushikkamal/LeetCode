package LeetCode;
// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (Integer i : nums) {
            x ^= i;
        }
        return x;
    }
}
