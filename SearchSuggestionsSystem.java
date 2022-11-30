// https://leetcode.com/problems/search-suggestions-system/description/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

class Node {
    private Node[] links;
    private boolean flag;

    Node() {
        links = new Node[26];
        flag = false;
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

    void setFlag() {
        flag = true;
    }

    boolean getFlag() {
        return flag;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    void insert(String s) {
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

    void dfs(Node node, String prefix, List<String> res) {
        if (res.size() == 3) {
            return;
        }

        if (node.getFlag()) {
            res.add(prefix);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (node.containsKey(c)) {
                dfs(node.get(c), prefix + c, res);
            }
        }
    }

    List<String> getPredictedWords(String prefix) {
        Node node = root;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!node.containsKey(ch)) {
                return new ArrayList<>();
            }

            node = node.get(ch);
        }

        dfs(node, prefix, res);
        return res;
    }
}

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie trie = new Trie();

        for (String product : products) {
            trie.insert(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            String substring = searchWord.substring(0, i + 1);

            List<String> predict = trie.getPredictedWords(substring);
            ans.add(new ArrayList<>(predict));
        }

        return ans;
    }
}
