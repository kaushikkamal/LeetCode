https://leetcode.com/problems/binary-tree-preorder-traversal/

    package LeetCode;

    public class BinaryTreePreorderTraversal {
        private void preOrder(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            ans.add(root.val);

            preOrder(root.left, ans);
            preOrder(root.right, ans);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            preOrder(root, ans);

            return ans;
        }
    }

## Iterative 

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();

        if (root == null) {
            return ans;
        }

        st.push(root);

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            ans.add(temp.val);

            if (temp.right != null) {
                st.push(temp.right);
            }
            
            if (temp.left != null) {
                st.push(temp.left);
            }
        }

        return ans;
    }
