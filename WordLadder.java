package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    static class Pair {
        String first;
        int second;

        Pair(String f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.first;
            int step = p.second;

            if (word.equals(endWord)) {
                return step;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArr = word.toCharArray();
                    charArr[i] = ch;
                    String newWord = new String(charArr);

                    if (set.contains(newWord)) {
                        q.offer(new Pair(newWord, step + 1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
