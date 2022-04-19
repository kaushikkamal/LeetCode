package LeetCode;

import java.util.ArrayList;

// https://leetcode.com/problems/shortest-distance-to-a-character/
public class ShortestDistanceToACharacter {
    public int minDis(ArrayList<Integer> loc, int i) {
        int dis = Integer.MAX_VALUE;
        for (Integer j : loc) {
            dis = Math.min(dis, Math.abs(j - i));
        }
        return dis;
    }

    public int[] shortestToChar(String s, char c) {
        int[] dis = new int[s.length()];
        ArrayList<Integer> loc = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                loc.add(i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            dis[i] = minDis(loc, i);
        }

        return dis;
    }
}
