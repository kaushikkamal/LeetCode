package LeetCode;

public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int space = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ++space;

                if (space == k) {
                    sb.append(s.substring(0, i));
                    break;
                }
            }
        }
        if (space < k) {
            return s;
        }
        return sb.toString();
    }
}
