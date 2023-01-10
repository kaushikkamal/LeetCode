package LeetCode;

public class LongestWordInDictionary {
    static class Node {
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

    static class Trie {
        private Node root;

        Trie() {
            root = new Node();
        }

        boolean insert(String s) {
            Node node = root;
            boolean commonPrefix = false;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (node.getFlag()) {
                    commonPrefix = true;
                }

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }

            node.setFlag();

            return commonPrefix;
        }
    }

    static public String longestWord(String[] words) {
        String res = "";
        Trie trie = new Trie();

        for (String word : words) {
            if (trie.insert(word)) {
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    System.out.println(res);
                    res = word;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = { "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y" };
        System.out.println(longestWord(arr));
    }
}
