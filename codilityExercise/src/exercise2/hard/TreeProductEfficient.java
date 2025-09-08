package exercise2.hard;

//Certainly! We can improve the solution by avoiding the need to explicitly find the sizes of all connected components. '
//        Instead, we can traverse the graph and keep track of the sizes dynamically while finding the three largest sizes.
//        This approach can reduce the memory usage and improve the overall efficiency.
//
//        Here's an updated Java implementation:

import java.util.ArrayList;
import java.util.List;

public class TreeProductEfficient {
    public String solution(int[] A, int[] B) {
        int N = A.length + 1;
        List<List<Integer>> graph = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }

        long max1 = 0, max2 = 0, max3 = 0;

        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                long size = dfs(graph, i, visited);

                if (size > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = size;
                } else if (size > max2) {
                    max3 = max2;
                    max2 = size;
                } else if (size > max3) {
                    max3 = size;
                }
            }
        }

        long result = Math.max(max1 * max2 * max3, max1 * max2);
        return Long.toString(result);
    }

    private long dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        visited[node] = true;
        long size = 1;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(graph, neighbor, visited);
            }
        }

        return size;
    }
}

//    This solution dynamically tracks the sizes of connected components while traversing the graph,
//        avoiding the need for an additional array to store component sizes.
//        The time complexity remains O(N), but the space complexity is reduced.