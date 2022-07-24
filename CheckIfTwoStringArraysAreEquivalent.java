// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent

public class CheckIfTwoStringArraysAreEquivalent {
    // 1 ms 41.8 MB
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    // 1 ms 42.6 MB
    // public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    // String one = "";
    // String two = "";

    // for(String s : word1){
    // one += s;
    // }

    // for(String s : word2){
    // two += s;
    // }

    // return one.equals(two);
    // }
}