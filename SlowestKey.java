package LeetCode;

// https://leetcode.com/problems/slowest-key/
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int max = releaseTimes[0];

        for (int i = 1; i < keysPressed.length(); i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] >= max) {
                if (releaseTimes[i] - releaseTimes[i - 1] > max) {
                    res = keysPressed.charAt(i);
                    max = releaseTimes[i] - releaseTimes[i - 1];
                } else if (keysPressed.charAt(i) > res) {
                    res = keysPressed.charAt(i);
                }
            }
        }

        return res;
    }
}
