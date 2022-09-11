// https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563

package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToBurnTree {
    static class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    private static BinaryTreeNode<Integer> markParents(BinaryTreeNode<Integer> root,
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap, int start) {
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> temp = q.poll();
            if (temp.data == start) {
                res = temp;
            }
            if (temp.left != null) {
                q.offer(temp.left);
                parentMap.put(temp.left, temp);
            }
            if (temp.right != null) {
                q.offer(temp.right);
                parentMap.put(temp.right, temp);
            }
        }
        return res;
    }

    private static int findMaxDistance(HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap,
            BinaryTreeNode<Integer> startNode) {
        HashSet<BinaryTreeNode<Integer>> visited = new HashSet<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        int level = 0;

        q.offer(startNode);
        visited.add(startNode);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean isBurn = false;

            while (size-- > 0) {
                BinaryTreeNode<Integer> temp = q.poll();

                if (temp.left != null && !visited.contains(temp.left)) {
                    isBurn = true;
                    q.offer(temp.left);
                    visited.add(temp.left);
                }
                if (temp.right != null && !visited.contains(temp.right)) {
                    isBurn = true;
                    q.offer(temp.right);
                    visited.add(temp.right);
                }

                if (parentMap.containsKey(temp) && !visited.contains(parentMap.get(temp))) {
                    isBurn = true;
                    q.offer(parentMap.get(temp));
                    visited.add(parentMap.get(temp));
                }
            }
            if (isBurn) {
                level++;
            }
        }
        return level;
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        // Write your code here.
        HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();

        BinaryTreeNode<Integer> startNode = markParents(root, parentMap, start); // make parent pointers

        return findMaxDistance(parentMap, startNode);
    }
}
