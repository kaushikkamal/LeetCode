package LeetCode;

// https://leetcode.com/problems/crawler-log-folder/
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int c = 0;

        for (String s : logs) {
            if (s.contains("../")) {
                if (c > 0) {
                    c--;
                }
            } else if (s.contains("./")) {
                continue;
            } else {
                c++;
            }
        }

        return c;
    }
}
