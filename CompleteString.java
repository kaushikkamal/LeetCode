package LeetCode;

public class CompleteString {
    static class Node {
        private Node[] links;
        private boolean isEndOfWord;

        Node() {
            links = new Node[26];
            isEndOfWord = false;
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

        boolean getEnd() {
            return this.isEndOfWord;
        }

        void setEnd() {
            this.isEndOfWord = true;
        }
    }

    static class Trie {
        private Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        boolean checkIfPrefixExists(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (node.containsKey(ch)) {
                    node = node.get(ch);
                    if (!node.getEnd()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static String completeString(int n, String[] a) {
        String res = "";
        Trie trie = new Trie();

        for (String it : a) {
            trie.insert(it);
        }

        for (String it : a) {
            if (trie.checkIfPrefixExists(it)) {
                if (it.length() > res.length()) {
                    res = it;
                } else if (it.length() == res.length() && it.compareTo(res) < 0) {
                    res = it;
                }
            }
        }

        if (res == "")
            return "None";

        return res;
    }
}