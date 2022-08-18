// https://practice.geeksforgeeks.org/problems/subset-sums2234/1

package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    private void sum(ArrayList<Integer> arr, int i, int sum, ArrayList<Integer> ans) {

        // base case
        if (i == arr.size()) {
            ans.add(sum);
            return;
        }

        // picked
        sum(arr, i + 1, sum + arr.get(i), ans);

        // not picked
        sum(arr, i + 1, sum, ans);
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> ans = new ArrayList<>();

        sum(arr, 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }
}
