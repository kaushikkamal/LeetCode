https://leetcode.com/problems/binary-tree-level-order-traversal/

    package LeetCode;

    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Queue;

    public class BinaryTreeLevelOrderTraversal {

        public static List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();

            if (root == null) {
                return ans;
            }

            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> list = new ArrayList<>();

                while (size-- > 0) {
                    TreeNode temp = q.poll();

                    if (temp.left != null) {
                        q.offer(temp.left);
                    }

                    if (temp.right != null) {
                        q.offer(temp.right);
                    }
                    list.add(temp.val);
                }
                ans.add(list);
            }
            return ans;
        }
    }
