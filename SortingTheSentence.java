// https://leetcode.com/problems/sorting-the-sentence/

package LeetCode;

public class SortingTheSentence {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        int i = 0;

        while (i < arr.length) {
            String cur = arr[i];
            int index = (cur.charAt(cur.length() - 1) - '0') - 1;

            if (i == index) {
                i++;
            } else {
                arr[i] = arr[index];
                arr[index] = cur;
            }
        }

        String ans = "";
        for (int k = 0; k < arr.length; k++) {
            arr[k] = arr[k].substring(0, arr[k].length() - 1);
            ans += arr[k];
            if (k != arr.length - 1) {
                ans += " ";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] arr = { "is2 sentence4 This1 a3", "Myself2 Me1 I4 and3" };
        for (String s : arr) {
            System.out.println(new SortingTheSentence().sortSentence(s));
        }
        // String cur = "is2";
        // int index = (cur.charAt(cur.length() - 1) - '0') - 1;
        // System.out.println(index);
    }
}
