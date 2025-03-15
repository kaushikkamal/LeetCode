package LeetCode;

import java.util.Stack;

public class MaxAreaOfBinaryMatrix {
    private static int[] nextSmallerElementRight(int[] heights) {
        int n = heights.length;
        int[] resIndex = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int index = n - 1; index >= 0; index--) {
            while (!s.isEmpty() && heights[index] <= heights[s.peek()]) {
                s.pop();
            }
            resIndex[index] = s.isEmpty() ? n : s.peek();
            s.push(index);
        }

        return resIndex;
    }

    private static int[] nextSmallerElementLeft(int[] heights) {
        int n = heights.length;
        int[] resIndex = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int index = 0; index < n; index++) {
            while (!s.isEmpty() && heights[index] <= heights[s.peek()]) {
                s.pop();
            }
            resIndex[index] = s.isEmpty() ? -1 : s.peek();
            s.push(index);
        }

        return resIndex;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        int[] nextSmallerElementRight = nextSmallerElementRight(heights);
        int[] nextSmallerElementLeft = nextSmallerElementLeft(heights);

        for (int heightIndex = 0; heightIndex < n; heightIndex++) {
            int height = heights[heightIndex];
            int width = nextSmallerElementRight[heightIndex] - nextSmallerElementLeft[heightIndex] - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    private static int maxAreaOfBinaryMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] heights = mat[0];
        int maxArea = 0;

        maxArea = largestRectangleArea(heights);

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (mat[row][col] == 0) {
                    heights[col] = 0;
                } else {
                    heights[col] = heights[col] + mat[row][col];
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] mat = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };

        System.out.println(maxAreaOfBinaryMatrix(mat));
    }
}
