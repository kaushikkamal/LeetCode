https://www.codingninjas.com/codestudio/problems/left-view-of-binary-tree_625707
    
    package LeetCode;

    import java.util.ArrayList;
    import java.util.List;

    public class LeftSideViewOfBinaryTree {

        private void leftView(TreeNode root, List<Integer> ans, int level) {
            if (root == null) {
                return;
            }

            if (level == ans.size()) {
                ans.add(root.data);
            }

            leftView(root.left, ans, level + 1);
            leftView(root.right, ans, level + 1);

        }

        public List<Integer> leftSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            leftView(root, ans, 0);

            return ans;
        }
    }
