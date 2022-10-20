// https://practice.geeksforgeeks.org/problems/word-ladder-ii/1

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderII {
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList) {
        Queue<ArrayList<String>> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        for (String s : wordList) {
            set.add(s);
        }

        ArrayList<ArrayList<String>> res = new ArrayList<>();

        if (!set.contains(endWord)) {
            return new ArrayList<>();
        }

        q.offer(new ArrayList<>(Arrays.asList(beginWord)));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<String> deletedString = new ArrayList<>();

            while (size-- > 0) {
                ArrayList<String> temp = q.poll();
                String word = temp.get(temp.size() - 1);

                if (word.equals(endWord)) {
                    if (res.size() == 0) {
                        res.add(temp);
                    } else if (res.get(0).size() == temp.size()) {
                        res.add(temp);
                    }
                }

                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] chArr = word.toCharArray();
                        chArr[i] = ch;
                        String newWord = new String(chArr);

                        if (set.contains(newWord)) {
                            ArrayList<String> newList = new ArrayList<>(temp);
                            newList.add(newWord);
                            q.offer(newList);

                            deletedString.add(newWord);
                        }
                    }
                }
            }

            for (String str : deletedString) {
                set.remove(str);
            }
        }
        return res;
    }
}
