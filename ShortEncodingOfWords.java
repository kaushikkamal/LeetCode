package LeetCode;

import java.util.Arrays;

public class ShortEncodingOfWords {
    static class Node {
        Node[] links;
        int size;

        Node() {
            this.links = new Node[26];
            this.size = -1;
        }

        boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return this.links[ch - 'a'];
        }

        int getSize() {
            return this.size;
        }

        void setSizeAsZero() {
            this.size = 0;
        }

        void setSize(int size) {
            this.size = size;
        }
    }

    static class Trie {
        private Node root;
        private int count;

        Trie() {
            root = new Node();
            count = 0;
        }

        public void insert(String s) {
            Node node = root;

            for (int i = s.length() - 1; i >= 0; i--) {
                char ch = s.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }

                node.setSizeAsZero();
                node = node.get(ch);
            }

            if (node.getSize() != 0 && node.getSize() != s.length()) {
                node.setSize(s.length());
                count += (s.length() + 1);
            }
        }

        public int referenceString() {
            return this.count;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        return trie.referenceString();
    }
}
