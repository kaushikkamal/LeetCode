https://leetcode.com/problems/binary-tree-inorder-traversal/

    package LeetCode;

    public class BinaryTreeInorderTraversal {
        public static void inorder(List<Integer> li, TreeNode root) {
            if (root == null) {
                return;
            }

            inorder(li, root.left);
            li.add(root.val);
            inorder(li, root.right);
        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> li = new ArrayList<>();
            if (root == null) {
                return new ArrayList<>();
            }

            inorder(li, root);

            return li;
        }
    }
