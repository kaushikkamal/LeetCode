https://leetcode.com/problems/binary-tree-right-side-view/

   # Recursive - Reverse Pre Order (Root Right Left)
    
    package LeetCode;
    
    public class RightSideViewOfBinaryTree {

        private void rightView(TreeNode root, List<Integer> ans, int level) {
            if (root == null) {
                return;
            }

            if (level == ans.size()) {
                ans.add(root.val);
            }

            rightView(root.right, ans, level + 1);
            rightView(root.left, ans, level + 1);
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();

            rightView(root, ans, 0);

            return ans;
        }
    }

# Level Order

    public class RightSideViewOfBinaryTree {

        static class Node {
            TreeNode node;
            int col;

            Node() {
            }

            Node(TreeNode node, int col) {
                this.node = node;
                this.col = col;
            }
        }

        public List<Integer> rightSideView(TreeNode root) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Queue<Node> q = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            q.offer(new Node(root, 0));

            while (!q.isEmpty()) {
                Node temp = q.poll();
                int col = temp.col;

                map.put(col, temp.node.val);

                if (temp.node.left != null) {
                    q.offer(new Node(temp.node.left, col + 1));
                }

                if (temp.node.right != null) {
                    q.offer(new Node(temp.node.right, col + 1));
                }
            }

            for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
                ans.add(mp.getValue());
            }

            return ans;
        }
    }
