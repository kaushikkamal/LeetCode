// https://leetcode.com/problems/combinations/

import java.util.List;
import java.util.ArrayList;

public class Combinations {
    public static void combination(int index, int n, int k, List<Integer> single, List<List<Integer>> list) {

        if (single.size() == k) {
            list.add(new ArrayList<>(single));
            return;
        }

        for (int i = index; i <= n; i++) {
            single.add(i);
            combination(i + 1, n, k, single, list);
            single.remove(single.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> single = new ArrayList<>();

        combination(1, n, k, single, list);

        return list;
    }
}
