package LeetCode;

// https://leetcode.com/problems/roman-to-integer
public class RomanToInteger {
    private int asd(char ch) {
        switch (ch) {
            case 'I': {
                return 1;
            }
            case 'V': {
                return 5;
            }
            case 'X': {
                return 10;
            }
            case 'L': {
                return 50;
            }
            case 'C': {
                return 100;
            }
            case 'D': {
                return 500;
            }
            case 'M': {
                return 1000;
            }
            default: {
                return -1;
            }
        }

    }

    public static int value(char r) {

        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    private static int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    res += s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res += s1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "MCMIV";
        System.out.println(romanToDecimal(str));
    }
}
