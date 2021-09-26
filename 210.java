// https://leetcode.com/problems/course-schedule-ii/
// 채점 : 8 ms	40.3 MB
// 공간 : O(N^2) 시간 : O(V+E)

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] connected = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] ans = new int[numCourses];
        int ansIdx = 0;
        
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            connected[prerequisites[i][0]] += 1;
        }
        
        int v = 0;
        for (; v < numCourses; v++) {
            for (int i = 0; i < numCourses; i++) {
                if (connected[i] == 0) {
                    queue.offer(i);
                    connected[i] -= 1;
                }
            }
            
            if (!queue.isEmpty()) {
                int vertex = queue.poll();
                ans[v] = vertex;
                ArrayList<Integer> nextClass = graph.get(vertex);
                for (int i = 0; i < nextClass.size(); i++) {
                    connected[nextClass.get(i)] -= 1;
                }
            } else {
                break;
            }

        }
        
        if (v < numCourses)
            return new int[0];
        else
            return ans;
    }
}
