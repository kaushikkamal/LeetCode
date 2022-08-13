// https://leetcode.com/problems/simplify-path/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Deque<String> s = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>(Arrays.asList("..", ".", ""));

        for (String str : path.split("/")) {
            if (str.equals("..") && !s.isEmpty()) {
                s.pop();
            } else if (!set.contains(str)) {
                s.push(str);
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (String dir : s) {
            sb.insert(0, "/" + dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
