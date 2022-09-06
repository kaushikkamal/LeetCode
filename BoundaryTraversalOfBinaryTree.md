https://leetcode.com/problems/boundary-of-binary-tree/
https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725

    package LeetCode;
    
    public class BoundaryTraversalOfBinaryTree {
        
        private static boolean isLeaf(TreeNode node) {
            return node.left == null && node.right == null;
        }

        private static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
            TreeNode cur = root.left;
            while (cur != null) {
                if (isLeaf(cur)) {
                    break;
                }
                ans.add(cur.data);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            }
        }

        private static void addLeaf(TreeNode root, ArrayList<Integer> ans) {
            if (isLeaf(root)) {
                ans.add(root.data);
                return;
            }

            if (root.left != null) {
                addLeaf(root.left, ans);
            }
            if (root.right != null) {
                addLeaf(root.right, ans);
            }
        }

        private static void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
            TreeNode cur = root.right;

            while (cur != null) {
                if (!isLeaf(cur)) {
                    ans.add(ans.size(), cur.data);
                }
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
        }

        public static ArrayList<Integer> traverseBoundary(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();

            ans.add(root.data);
            if (isLeaf(root)) {
                return ans;
            }

            addLeftBoundary(root, ans);
            addLeaf(root, ans);
            addRightBoundary(root, ans);

            return ans;
        }
    }
