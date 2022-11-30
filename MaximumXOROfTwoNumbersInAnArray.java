// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

package LeetCode;

class Node {
    private Node[] links;

    Node() {
        links = new Node[2];
    }

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }

    Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }

    }

    int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int maxNum = 0;

        for (int num : nums) {
            trie.insert(num);
        }

        for (int num : nums) {
            maxNum = Math.max(maxNum, trie.getMax(num));
        }
        return maxNum;
    }
}
