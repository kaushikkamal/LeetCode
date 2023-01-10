// https://leetcode.com/problems/detect-capital/description/

package LeetCode;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int caps = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                caps++;
            }
        }

        if (caps == 0 || caps == word.length()) {
            return true;
        }

        return (caps == 1 && Character.isUpperCase(word.charAt(0)));
    }

    // ------------------------------------------------------------------------------

    private boolean checkForAllLetterCapital(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkForAllLetterASmall(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkForOnlyFirstLetterCapital(String word) {
        int idx = -1;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                idx = i;
            }
        }
        return idx == 0;
    }

    public boolean detectCapitalUse_(String word) {
        return checkForAllLetterCapital(word) || checkForAllLetterASmall(word) || checkForOnlyFirstLetterCapital(word);
    }
}
