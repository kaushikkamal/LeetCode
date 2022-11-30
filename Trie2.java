// https://www.codingninjas.com/codestudio/problems/implement-trie_1387095

package LeetCode;

class Node {
    private Node[] links;
    private int endWord;
    private int countPrefix;

    Node() {
        links = new Node[26];
        endWord = 0;
        countPrefix = 0;
    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch) {
        links[ch - 'a'] = new Node();
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    int getEndWord() {
        return this.endWord;
    }

    void increaseEndWord() {
        endWord++;
    }

    void reduceEndWord() {
        endWord--;
    }

    int getCountPrefix() {
        return this.countPrefix;
    }

    void increaseCountPrefix() {
        countPrefix++;
    }

    void reduceCountPrefix() {
        countPrefix--;
    }
}

public class Trie2 {
    private static Node root;

    public Trie2() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch);
            }

            node = node.get(ch);
            node.increaseCountPrefix();
        }

        node.increaseEndWord();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                return 0;
            }

            node = node.get(ch);
        }
        return node.getEndWord() < 0 ? 0 : node.getEndWord();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getCountPrefix() < 0 ? 0 : node.getCountPrefix();
    }

    public void erase(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                return;
            }

            node = node.get(ch);
            node.reduceCountPrefix();
        }
        node.reduceEndWord();
    }
}
