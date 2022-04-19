package LeetCode;

public class StringToInt {
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        double res = 0;
        int startIndex = 0;
        int multi = 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            startIndex++;
            if (s.charAt(0) == '-') {
                multi = -1;
            }
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            res = res * 10 + (int) (s.charAt(i) - '0');
        }
        res = res * multi;

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
