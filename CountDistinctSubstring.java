// https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?leftPanelTab=0

package LeetCode;

class Node {
    private Node[] links;

    Node() {
        links = new Node[26];
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
}

public class CountDistinctSubstring {
    public static int countDistinctSubstrings(String s) {
        Node root = new Node();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            Node node = root;

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!node.containsKey(ch)) {
                    count++;
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
        }
        return count + 1;
    }
}
