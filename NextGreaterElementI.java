// https://leetcode.com/problems/next-greater-element-i/

package LeetCode;

import java.util.*;

public class NextGreaterElementI {

    // TC -> O(N)
    // SC -> O(1)

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!s.isEmpty() && num > s.peek()) { // >= may needed
                map.put(s.pop(), num);
            }
            s.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    // TC -> O(N^2)
    // SC -> O(N)

    public static int[] nextGreaterElement_(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        Arrays.fill(res, -1);

        for (int i = 0; i < nums1.length; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (s.isEmpty()) {
                    s.push(nums2[j]);
                } else {
                    while (!s.isEmpty() && nums2[j] > s.peek()) {
                        s.pop();
                    }
                }

                if (nums1[i] == nums2[j]) {
                    if (!s.isEmpty() && nums1[i] != s.peek()) {
                        res[i] = s.peek();
                    }
                    break;
                }

                s.push(nums2[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
