package LeetCode;

// https://leetcode.com/problems/majority-element/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm
        int count = 0, ele = 0;

        for (int num : nums) {
            if (count == 0) {
                ele = num;
            }
            if (ele == num) {
                count++;
            } else {
                count--;
            }
        }
        return ele;
    }

    // public int majorityElement(int[] nums) {
    // Arrays.sort(nums);
    // return nums[nums.length / 2];
    // }

    // public int majorityElement(int[] nums) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // int n = nums.length / 2;
    // for (int i : nums) {
    // map.put(i, map.getOrDefault(i, 0) + 1);

    // if (map.get(i) > n) {
    // return i;
    // }
    // }
    // return -1;
    // }
}
