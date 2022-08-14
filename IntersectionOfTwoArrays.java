// https://leetcode.com/problems/intersection-of-two-arrays/

// TC -> O(log(n))
// SC -> O(N)

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);

                while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                i++;

                while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) {
                    j++;
                }
                j++;
            } else if (nums1[i] < nums2[j]) {
                while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) {
                    i++;
                }
                i++;
            } else {
                while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) {
                    j++;
                }
                j++;
            }
        }

        int[] arr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }
        return arr;
    }
}
