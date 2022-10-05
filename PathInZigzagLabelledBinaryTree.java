// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int nodeValue = 1;
        int level = 1;

        while (label >= 2 * nodeValue) {
            nodeValue *= 2;
            level++;
        }

        while (label != 0) {
            ans.add(label);
            int min = (int) Math.pow(2, level - 1);
            int max = (int) Math.pow(2, level) - 1;

            label = (max + min - label) / 2;
            level--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
