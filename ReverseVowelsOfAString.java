// https://leetcode.com/problems/reverse-vowels-of-a-string/description/

package LeetCode;

public class ReverseVowelsOfAString {
    private boolean isVowel(char letter) {
        letter = Character.toLowerCase(letter);
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
            return true;
        }
        return false;
    }

    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (isVowel(charArr[start]) && isVowel(charArr[end])) {
                char temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;
                start++;
                end--;
            } else if (isVowel(charArr[start])) {
                end--;
            } else {
                start++;
            }
        }

        return new String(charArr);
    }
}
