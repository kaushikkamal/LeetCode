// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {
    private void pushAll(TreeNode root, Deque<TreeNode> s1) {
        while (root != null) {
            s1.push(root);
            root = root.left;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();

        pushAll(root1, s1);
        pushAll(root2, s2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek().val <= s2.peek().val) {
                TreeNode temp = s1.pop();
                ans.add(temp.val);

                if (temp.right != null) {
                    pushAll(temp.right, s1);
                }
            } else {
                TreeNode temp = s2.pop();
                ans.add(temp.val);

                if (temp.right != null) {
                    pushAll(temp.right, s2);
                }
            }
        }

        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            ans.add(temp.val);

            if (temp.right != null) {
                pushAll(temp.right, s1);
            }
        }

        while (!s2.isEmpty()) {
            TreeNode temp = s2.pop();
            ans.add(temp.val);

            if (temp.right != null) {
                pushAll(temp.right, s2);
            }
        }
        return ans;
    }
}
