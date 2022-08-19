package LeetCode;

// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String s : sentences) {
            String[] str = s.split(" ");

            max = Math.max(max, str.length);
        }

        return max;
    }
}
