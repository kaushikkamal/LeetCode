package LeetCode;
// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String s : sentences) {
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    c++;
                }
            }

            max = Math.max(max, c + 1);
        }

        return max;
    }
}
