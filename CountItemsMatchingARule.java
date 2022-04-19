package LeetCode;

import java.util.List;

// https://leetcode.com/problems/count-items-matching-a-rule/
public class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int c = 0;

        for (List<String> list : items) {
            if (ruleKey.equals("type") && ruleValue.equals(list.get(0))) {
                c++;
            } else if (ruleKey.equals("color") && ruleValue.equals(list.get(1))) {
                c++;
            } else if (ruleKey.equals("name") && ruleValue.equals(list.get(2))) {
                c++;
            }
        }

        return c;
    }
}
