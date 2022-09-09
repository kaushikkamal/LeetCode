https://www.interviewbit.com/problems/path-to-given-node/

    package LeetCode;

    public class PathToGivenNode {
        
        public boolean getPath(TreeNode root, ArrayList<Integer> ans, int target) {
            if(root == null) {
                return false;
            }
            
            ans.add(root.val);
            
            if(root.val == target) {
                return true;
            }
            
            if(getPath(root.left, ans, target) || getPath(root.right, ans, target)) {
                return true;
            }
        
            ans.remove(ans.size() - 1);
            
            return false;
        }
        
        public ArrayList<Integer> solve(TreeNode root, int target) {
            ArrayList<Integer> ans = new ArrayList<>();
            
            getPath(root, ans, target);
            
            return ans;
        }
    }
