// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

package LeetCode;

public class SuccessorAndPredecessorInBST {

    static class Res {
        TreeNode pre, succ;
    }

    public static void findPreSuc(TreeNode root, Res res, int key) {

        TreeNode cur = root;

        while (cur != null) {
            if (cur.val <= key) {
                cur = cur.right;
            } else {
                res.succ = cur;
                cur = cur.left;
            }
        }

        cur = root;

        while (cur != null) {
            if (cur.val < key) {
                res.pre = cur;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
    }

    private static TreeNode succesor(TreeNode root, int val) {
        TreeNode cur = root;
        TreeNode res = null;

        while (cur != null) {
            if (cur.val <= val) {
                cur = cur.right;
            } else {
                res = cur;
                cur = cur.left;
            }
        }
        return res;
    }

    private static TreeNode predecessor(TreeNode root, int val) {
        TreeNode cur = root;
        TreeNode res = null;

        while (cur != null) {
            if (cur.val < val) {
                res = cur;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);

        // TreeNode res = predecessor(root, 8);
        // if (res == null) {
        // System.out.println("null");
        // return;
        // }
        // System.out.println(res.val);
        Res res = new Res();
        findPreSuc(root, res, 8);

        if (res.pre != null) {
            System.out.println(res.pre.val);
        }
        if (res.succ != null) {
            System.out.println(res.succ.val);
        }
    }
}
