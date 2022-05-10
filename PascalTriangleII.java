package LeetCode;

// https://leetcode.com/problems/pascals-triangle-ii/
import java.util.ArrayList;

public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        // nC0 = 1
        ArrayList<Integer> list = new ArrayList<>();
        long prev = 1;
        list.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            // nCr = (nCr-1 * (n - r + 1))/r
            long cur = prev * (rowIndex - i + 1) / i;
            list.add((int) cur);
            prev = cur;
        }
        return list;
    }
}
