// https://leetcode.com/problems/merge-strings-alternately/description/

package LeetCode;

public class MergeStringsAlternately {

    // one pointer

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.max(len1, len2);

        for (int i = 0; i < len; i++) {
            if (i < len1) {
                sb.append(word1.charAt(i));
            }
            if (i < len2) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }

    // two pointer

    public String mergeAlternately_(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));

            i++;
            j++;
        }

        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }

        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}
