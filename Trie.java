// https://leetcode.com/problems/implement-trie-prefix-tree/

package LeetCode;

class Node {
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

public class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }

        return node.getEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!node.containsKey(ch)) {
                return false;
            }

            node = node.get(ch);
        }
        return true;
    }
}
