package LeetCode;

import java.util.HashSet;

// https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String s : emails) {
            String[] arr = s.split("@");
            String str = "";

            for (char c : arr[0].toCharArray()) {
                if (c == '.') {
                    continue;
                }
                if (c == '+') {
                    break;
                }
                str += c;
            }

            str += "@" + arr[1];

            set.add(str);
        }

        return set.size();
    }
}
