https://leetcode.com/problems/balanced-binary-tree/

    package LeetCode;

    public class BalancedBinaryTree {
        private int height(TreeNode root) {
            if(root == null) {
                return 0;
            }
            
            int left = height(root.left);
            if(left == -1) {
                return -1;
            }
            
            int right = height(root.right);
            if(right == -1) {
                return -1;
            }
            
            if(Math.abs(left - right) > 1) {
                return -1;
            }
            
            return 1 + Math.max(left, right);
        }
        
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }
    }

# Brute Force Recursive

    public class BalancedBinaryTree {
        private int height(TreeNode root) {
            if(root == null) {
                return 0;
            }
            
            return 1 + Math.max(height(root.left), height(root.right));
        }

        public boolean isBalanced(TreeNode root) {
            if(root == null) {
                return true;
            }
            
            int leftSubTreeHeight = height(root.left);
            int rightSubTreeHeight = height(root.right);
            
            if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
                return false;
            }
            
            boolean leftBalance = isBalanced(root.left);
            boolean rightBalance = isBalanced(root.right);
            
            if(!leftBalance || !rightBalance ) {
                return false;
            }
            return true;
        }
    }   

# Brute Force Iterative

    public class BalancedBinaryTree {
        private int height(TreeNode root) {
            if(root == null) {
                return 0;
            }
            
            return 1 + Math.max(height(root.left), height(root.right));
        }

        public boolean isBalanced(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            if(root == null) {
                return true;
            }
            
            q.offer(root);
            
            while(!q.isEmpty()) {
                int size = q.size();
                
                while(size-- > 0) {
                    TreeNode temp = q.poll();
                    
                    int leftSubTreeHeight = height(temp.left);
                    int rightSubTreeHeight = height(temp.right);
                    
                    if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
                        return false;
                    }
                    
                    if(temp.left != null) {
                        q.offer(temp.left);
                    }
                    if(temp.right != null) {
                        q.offer(temp.right);
                    }
                }
            }
            return true;
        }
    }
