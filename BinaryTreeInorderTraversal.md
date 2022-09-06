https://leetcode.com/problems/binary-tree-inorder-traversal/

    package LeetCode;

    public class BinaryTreeInorderTraversal {
        public static void inOrder(TreeNode root, List<Integer> ans){
            if(root == null){
                return;
            }
            
            inOrder(root.left, ans);
            ans.add(root.val);
            inOrder(root.right, ans);
        }
    
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>(); 
            if(root == null){
                return ans;
            }
            
            inOrder(root, ans);
            
            return ans;
        }
    }

## Iterative 

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>(); 
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = root;
        
        while(temp != null || !stack.isEmpty()){
            while(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            ans.add(temp.val);
            temp = temp.right;
        }
        
        return ans;
    }