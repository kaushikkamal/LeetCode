// https://leetcode.com/problems/find-players-with-zero-or-one-losses/?envType=daily-question&envId=2024-01-15

package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> inorder = new TreeMap<>();

        for (int[] each : matches) {
            inorder.putIfAbsent(each[0], 0);
            inorder.put(each[1], inorder.getOrDefault(each[1], 0) + 1);
        }

        List<Integer> zeroMatchLosser = new ArrayList<>();
        List<Integer> oneMatchLosser = new ArrayList<>();

        for (Map.Entry<Integer, Integer> mp : inorder.entrySet()) {
            if (mp.getValue() == 0) {
                zeroMatchLosser.add(mp.getKey());
            } else if (mp.getValue() == 1) {
                oneMatchLosser.add(mp.getKey());
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(zeroMatchLosser);
        res.add(oneMatchLosser);

        return res;

    }
}
