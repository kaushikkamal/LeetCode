package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    private boolean isMatch(char[] queryArr, char[] patternArr) {
        int j = 0;

        for (int i = 0; i < queryArr.length; i++) {
            if (j < patternArr.length && queryArr[i] == patternArr[j]) {
                j++;
            } else if (Character.isUpperCase(queryArr[i])) {
                return false;
            }
        }
        return j == patternArr.length;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        char[] patternArr = pattern.toCharArray();

        for (String query : queries) {
            boolean val = isMatch(query.toCharArray(), patternArr);
            res.add(val);
        }
        return res;
    }
}
