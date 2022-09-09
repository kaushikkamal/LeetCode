https://leetcode.com/problems/symmetric-tree/

    public class SymmetricTree {

        private boolean check(TreeNode leftNode, TreeNode rightNode) {
            if(leftNode == null && rightNode == null) {
                return true;
            }
            
            if(leftNode == null || rightNode == null) {
                return false;
            }
            
            return leftNode.val == rightNode.val && check(leftNode.left, rightNode.right) && check(leftNode.right, rightNode.left);
        }
        
        public boolean isSymmetric(TreeNode root) {
            return root == null || check(root.left, root.right);
        }
    }