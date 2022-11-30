// https://leetcode.com/problems/lexicographical-numbers/description/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbersWithoutTrie {
    private void dfs(List<Integer> res, int num, int n) {
        if (num > n) {
            return;
        }

        res.add(num);

        for (int i = 0; i < 10; i++) {
            if (num * 10 + i > n) {
                return;
            }
            dfs(res, num * 10 + i, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(res, i, n);
        }

        return res;
    }
}
