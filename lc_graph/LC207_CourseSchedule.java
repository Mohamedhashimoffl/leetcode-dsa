// LeetCode Problem: 207. Course Schedule
// Link: https://leetcode.com/problems/course-schedule/
// Difficulty: Medium
// Tags: Graph, Topological Sort, BFS
// Time Complexity: O(V + E) where V = number of courses, E = number of prerequisites
// Space Complexity: O(V + E)

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph and compute in-degree of each course
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph.get(prereqCourse).add(course);
            inDegree[course]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int finishedCourses = 0;

        // Process courses with zero in-degree
        while (!queue.isEmpty()) {
            int current = queue.poll();
            finishedCourses++;

            for (int neighbour : graph.get(current)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        
        // If all courses finished, return true
        return finishedCourses == numCourses;
    }
}
