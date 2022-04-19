package LeetCode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length > nums2.length) {
            for (int i = 0; i < nums1.length; i++) {

            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        new MergeSortedArray().merge(nums1, m, nums2, n);
    }
}
