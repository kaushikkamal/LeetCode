package LeetCode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> inHash) {

        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inHash.get(root.val);
        int nElem = rootIndex - inStart;

        root.left = buildTree(postorder, postStart, postStart + nElem - 1, inorder, inStart, rootIndex - 1, inHash);

        root.right = buildTree(postorder, postStart + nElem, postEnd - 1, inorder, rootIndex + 1, inEnd, inHash);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        HashMap<Integer, Integer> inHash = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inHash.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inHash);
    }
}
