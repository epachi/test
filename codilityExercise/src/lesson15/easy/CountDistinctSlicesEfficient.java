package lesson15.easy;

//To achieve a more efficient solution, we can use the fact that if we know the number of distinct slices
// ending at position end,
// we can easily compute the number of distinct slices starting at position end + 1.
// We don't need to iterate through each possible slice separately. (Can be used with catepillar method.....)
//
//Here's an optimized Java solution:
public class CountDistinctSlicesEfficient {
    public int solution(int M, int[] A) {
        int[] lastOccurrence = new int[M + 1];
        int distinctSlices = 0;
        int start = 0;

        for (int end = 0; end < A.length; end++) {
            start = Math.max(start, lastOccurrence[A[end]] + 1);
            distinctSlices += (end - start + 1);
            lastOccurrence[A[end]] = end;

            if (distinctSlices > 1_000_000_000) {
                return 1_000_000_000;
            }
        }

        return distinctSlices;
    }
    public static void main(String[] args) {
        CountDistinctSlicesRevisited solution = new CountDistinctSlicesRevisited();
        int M = 6;
        int [] A = {3, 4, 5, 5, 2};

        int distinctSlices = solution.solution(M, A);

        System.out.println("distinctSlices==>" + distinctSlices);

    }
}


//This solution uses an array lastOccurrence to keep track of the last occurrence index of each element.
// The start pointer is updated to the maximum of its current position and the last occurrence index of the current element + 1.
// This ensures that we only consider distinct slices.
//
//The time complexity of this solution is O(N), where N is the length of array A.
// The space complexity is O(M), where M is the value of the parameter M.