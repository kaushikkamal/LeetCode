package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                maxNum = Math.max(maxNum, num.charAt(i) - '0');
            }
        }

        if (maxNum == Integer.MIN_VALUE) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxNum).append(maxNum).append(maxNum);

        // for (int i = 0; i < 3; i++) { // 1 // 4 // 3
        // sb.append(maxNum); // 3
        // }

        return sb.toString();
    }

    public String largestGoodInteger_(String num) {
        Deque<Character> s = new ArrayDeque<>();
        int count = 1;
        int maxNum = Integer.MIN_VALUE;

        for (char each : num.toCharArray()) {
            if (!s.isEmpty() && s.peek() == each) {
                count++;
                if (count == 3) {
                    maxNum = Math.max(maxNum, each - '0');
                }
            } else {
                count = 1;
            }

            s.push(each);
        }

        if (maxNum == Integer.MIN_VALUE) {
            return "";
        }

        StringBuilder resNum = new StringBuilder();
        resNum.append(maxNum).append(maxNum).append(maxNum);

        return resNum.toString();
    }
}