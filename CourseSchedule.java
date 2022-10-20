package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int num : adj.get(i)) {
                indegree[num]++;
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();

            count++;

            for (int num : adj.get(temp)) {
                indegree[num]--;

                if (indegree[num] == 0) {
                    q.offer(num);
                }
            }
        }

        return count == numCourses;
    }
}
