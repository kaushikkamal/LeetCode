// https://leetcode.com/problems/leaf-similar-trees/

package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeafSimilarTrees {
    private int dfs(Deque<TreeNode> s) {
        while (true) {
            TreeNode temp = s.pop();

            if (temp.right != null) {
                s.push(temp.right);
            }

            if (temp.left != null) {
                s.push(temp.left);
            }

            if (temp.left == null && temp.right == null) {
                return temp.val;
            }
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();

        s1.push(root1);
        s2.push(root2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (dfs(s1) != dfs(s2)) {
                return false;
            }
        }

        return s1.isEmpty() && s2.isEmpty();
    }
}
