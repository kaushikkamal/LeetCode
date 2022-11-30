// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {
    static class Node {
        Node[] links;
        boolean flag;

        Node() {
            this.links = new Node[26];
            this.flag = false;
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

        boolean insert(String prefix) {
            Node node = root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (ch == '/') {
                    continue;
                }

                if (!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }

                node = node.get(ch);

                if (node.getFlag() && i + 1 < prefix.length() && prefix.charAt(i + 1) == '/') {
                    return false;
                }
            }

            node.setFlag();
            return true;
        }
    }

    public static List<String> removeSubfolders(String[] folders) {
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();

        Arrays.sort(folders, (a, b) -> a.length() - b.length());

        for (String folder : folders) {
            if (trie.insert(folder)) {
                ans.add(folder);
            }
        }

        return ans;
    }
}
