// https://leetcode.com/problems/course-schedule-ii/

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int n = prerequisites.length;

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int num : adj.get(i)) {
                indegree[num]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int i = 0;
        int[] res = new int[numCourses];

        while (!q.isEmpty()) {
            int temp = q.poll();

            res[i++] = temp;

            for (int num : adj.get(temp)) {
                indegree[num]--;

                if (indegree[num] == 0) {
                    q.offer(num);
                }
            }
        }

        if (i == numCourses) {
            return res;
        }

        return new int[] {};
    }
}
