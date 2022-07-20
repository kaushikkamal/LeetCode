// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

// TC -> O(log(n))
// SC -> O(1)

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return letters[start % N];
    }
}
