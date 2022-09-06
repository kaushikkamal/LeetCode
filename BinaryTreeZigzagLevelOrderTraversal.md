https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

    package LeetCode;

    public class BinaryTreeZigzagLevelOrderTraversal {

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            boolean leftToRight = true;

            if (root == null) {
                return ans;
            }

            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> level = new ArrayList<>();

                while (size-- > 0) {
                    TreeNode temp = q.poll();
                    if (leftToRight)
                        level.add(temp.val);
                    else
                        level.add(0, temp.val);

                    if (temp.left != null)
                        q.offer(temp.left);

                    if (temp.right != null)
                        q.offer(temp.right);
                }
                ans.add(level);
                leftToRight = !leftToRight;
            }
            return ans;
        }
    }
