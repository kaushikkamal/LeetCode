package LeetCode;

// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int c = 0;

        for (String s : operations) {
            if (s.charAt(1) == '+') {
                c++;
            } else {
                c--;
            }
        }
        return c;
    }
}
