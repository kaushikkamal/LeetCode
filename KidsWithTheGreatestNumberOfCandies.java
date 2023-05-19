// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/

package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> res = new ArrayList<>();

        for (int each : candies) {
            max = Math.max(max, each);
        }

        for (int each : candies) {
            if (each + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }
    
    // public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    //     int max = candies[0];
    //     List<Boolean> res = new ArrayList<>(Collections.nCopies(candies.length, false));

    //     for (int i = 1; i < candies.length; i++) {
    //         max = Math.max(max, candies[i]);
    //     }

    //     for (int i = 0; i < candies.length; i++) {
    //         if (candies[i] + extraCandies >= max) {
    //             res.set(i, true);
    //         }
    //     }
    //     return res;
    // }
}
