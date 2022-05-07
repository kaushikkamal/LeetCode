package LeetCode;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
public class AAAAAAMinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int[] number = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) != '0') {
                    number[i] += Math.abs(j - i);
                }
            }
        }
        return number;
    }
}
