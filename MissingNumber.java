// https://leetcode.com/problems/missing-number/

// TC -> O(N)
// SC -> O(1)

public class MissingNumber {
    public int missingNumber(int[] arr) {
        int N = arr.length;
        int sum = N;

        for (int i = 0; i < N; i++) {
            sum += (i - arr[i]);
        }

        return sum;
    }
}
