package LeetCode;

// https://leetcode.com/problems/rank-teams-by-votes/
import java.util.*;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {

        HashMap<Character, int[]> map = new HashMap<>();

        int n = votes[0].length();

        for (String s : votes) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.putIfAbsent(c, new int[n]);
                map.get(c)[i]++;
            }
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            for (int i = 0; i < n; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
