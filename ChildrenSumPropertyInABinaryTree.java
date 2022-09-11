// https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/

package LeetCode;

public class ChildrenSumPropertyInABinaryTree {
    static class Node {
        int val;
        Node left;
        Node right;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static void changeTree(Node root) {
        if (root == null) {
            return;
        }

        int left = 0, right = 0;

        if (root.left != null) {
            left = root.left.val;
        }

        if (root.right != null) {
            right = root.right.val;
        }

        if (root.val > left + right) {
            if (root.left != null) {
                root.left.val = root.val;
            }
            if (root.right != null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        if (root.left != null) {
            left = root.left.val;
        }

        if (root.right != null) {
            right = root.right.val;
        }

        if (root.left != null || root.right != null) {
            root.val = left + right;
        }
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(35);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(10);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        preOrder(root);
        System.out.println();
        changeTree(root);
        preOrder(root);
    }
}
