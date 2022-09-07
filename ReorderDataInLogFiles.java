// https://leetcode.com/problems/reorder-data-in-log-files/

package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] arr1 = s1.split(" ", 2);
                String[] arr2 = s2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(arr1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int com = arr1[1].compareTo(arr2[1]);
                    if (com != 0) {
                        return com;
                    }

                    return arr1[0].compareTo(arr2[0]);
                }

                if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }

            }
        };

        Arrays.sort(logs, comp);

        return logs;
    }
}
