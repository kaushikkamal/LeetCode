// https://leetcode.com/problems/last-stone-weight/
package LeetCode;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}
