package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    class Pair {
        int node, step;

        Pair(int n, int s) {
            this.node = n;
            this.step = s;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        int[] stepArr = new int[100000];

        Arrays.fill(stepArr, Integer.MAX_VALUE);
        stepArr[start] = 0;
        q.offer(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int step = p.step;

            for (int num : arr) {
                int newNode = (node * num) % 100000;
                int newStep = step + 1;

                if (newNode == end) {
                    return newStep;
                }

                if (newStep < stepArr[newNode]) {
                    stepArr[newNode] = newStep;
                    q.offer(new Pair(newNode, newStep));
                }
            }
        }

        return -1;
    }
}
