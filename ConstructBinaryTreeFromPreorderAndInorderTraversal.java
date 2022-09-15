// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

package LeetCode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inHash) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = inHash.get(root.val);
        int nElem = rootIndex - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + nElem, inorder, inStart, rootIndex - 1, inHash);

        root.right = buildTree(preorder, preStart + nElem + 1, preEnd, inorder, rootIndex + 1, inEnd, inHash);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inHash = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inHash.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inHash);
    }
}
