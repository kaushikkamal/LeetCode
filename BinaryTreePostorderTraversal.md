https://leetcode.com/problems/binary-tree-postorder-traversal/

    package LeetCode;

    public class BinaryTreePostorderTraversal {
        private void postOrder(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            postOrder(root.left, ans);
            postOrder(root.right, ans);

            ans.add(root.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            postOrder(root, ans);

            return ans;
        }
    }

# Iterative

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    ans.add(temp.val);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                } else {
                    cur = temp;
                }
            }
        }
        return ans;
    }