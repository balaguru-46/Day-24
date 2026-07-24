import java.util.*;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[1001];

        queue.offer(start);
        visited[start] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();

                for (int num : nums) {
                    int[] nextValues = {
                        current + num,
                        current - num,
                        current ^ num
                    };

                    for (int next : nextValues) {
                        // Goal can be outside [0,1000]
                        if (next == goal) {
                            return steps + 1;
                        }

                        // Only continue BFS for valid range
                        if (next >= 0 && next <= 1000 && !visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}