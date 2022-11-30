// https://leetcode.com/problems/replace-words/description/

package LeetCode;

import java.util.List;

public class ReplaceWords {
    static class Node {
        Node[] links;
        int idx;

        Node() {
            this.links = new Node[26];
            this.idx = -1;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        int getIndex() {
            return this.idx;
        }

        void setIndex(int idx) {
            this.idx = idx;
        }
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        void insert(String prefix, int index) {
            Node node = root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }

                node = node.get(ch);
            }

            node.setIndex(index);
        }

        int findPrefix(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (node.getIndex() != -1) {
                    return node.getIndex();
                }

                if (node.containsKey(ch)) {
                    node = node.get(ch);
                } else {
                    break;
                }
            }
            return -1;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i), i);
        }

        String[] strArr = sentence.trim().split(" ");

        for (int i = 0; i < strArr.length; i++) {
            int indexToReplace = trie.findPrefix(strArr[i]);

            if (indexToReplace != -1) {
                strArr[i] = dictionary.get(indexToReplace);
            }
        }

        return String.join(" ", strArr);
    }
}
