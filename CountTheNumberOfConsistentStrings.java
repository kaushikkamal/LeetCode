// https://leetcode.com/problems/count-the-number-of-consistent-strings/

public class CountTheNumberOfConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;

        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (allowed.indexOf(c) == -1) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
