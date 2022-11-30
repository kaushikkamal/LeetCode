// https://leetcode.com/problems/lexicographical-numbers/description/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbersWithTrie {
    static class Node {
        Node[] links;
        boolean flag;

        Node() {
            this.links = new Node[10];
            this.flag = false;
        }

        boolean containsKey(char ch) {
            return this.links[ch - '0'] != null;
        }

        void put(char ch, Node node) {
            this.links[ch - '0'] = node;
        }

        Node get(char ch) {
            return this.links[ch - '0'];
        }

        boolean getFlag() {
            return this.flag;
        }

        void setFlag() {
            this.flag = true;
        }
    }

    static class Trie {
        private static Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String s) {
            Node node = root;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }

                node = node.get(ch);
            }

            node.setFlag();
        }

        private void dfs(Node cur, List<Integer> res, String op) {
            if (cur.getFlag()) {
                res.add(Integer.parseInt(op));
            }

            for (char ch = '0'; ch <= '9'; ch++) {
                if (cur.containsKey(ch)) {
                    dfs(cur.get(ch), res, op + ch);
                }
            }
        }

        public List<Integer> findLexicographicalOrder() {
            Node node = root;
            List<Integer> res = new ArrayList<>();

            dfs(node, res, "");

            return res;
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        Trie trie = new Trie();

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);

            trie.insert(s);
        }

        res = trie.findLexicographicalOrder();
        return res;
    }
}
