// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

package LeetCode;

public class DesignAddAndSearchWordsDataStructure {
    class Node {
        Node[] links;
        boolean flag;

        Node() {
            this.links = new Node[26];
            this.flag = false;
        }

        boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        void put(char ch, Node node) {
            this.links[ch - 'a'] = node;
        }

        Node get(char ch) {
            return this.links[ch - 'a'];
        }

        boolean getFlag() {
            return this.flag;
        }

        void setFlag() {
            this.flag = true;
        }
    }

    class WordDictionary {
        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }

                node = node.get(ch);
            }

            node.setFlag();
        }

        private boolean dfs(Node node, int index, String word) {
            if (index == word.length()) {
                return node.getFlag();
            }

            char curChar = word.charAt(index);

            if (curChar != '.') {
                return node.containsKey(curChar) && dfs(node.get(curChar), index + 1, word);
            }

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (node.containsKey(ch)) {
                    boolean res = dfs(node.get(ch), index + 1, word);
                    if (res) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean search(String word) {
            Node node = root;
            return dfs(node, 0, word);
        }
    }
}
