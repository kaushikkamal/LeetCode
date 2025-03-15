// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays

package LeetCode;

public class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        final int N = A.length;
        int[] res = new int[N];
        int[] freq = new int[N + 1];
        int count = 0;

        for (int i = 0; i < N; i++) {
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                count++;
            }

            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                count++;
            }

            res[i] = count;
        }
        return res;
    }
}
