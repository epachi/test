package lesson14.medium;

//
//Certainly! We can further optimize the solution by using the concept of prefix sums.
//        We will create an array to represent the cumulative count of nails at each position.
//        This array will help us quickly determine the count of nails in a given range.
import java.util.*;

//Use binary Search
public class NailingPlanksClaudeWrong {
    public int solution(int[] A, int[] B, int[] C) {
        int N = A.length;
        int M = C.length;

        // Create list of nails with (position, original_index)
        List<int[]> sortedNails = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            sortedNails.add(new int[]{C[i], i});
        }
        // Sort nails by position
        sortedNails.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Extract positions for binary search
        int[] nailPositions = sortedNails.stream().mapToInt(x -> x[0]).toArray();

        // Binary search on the number of nails to use (J)
        int low = 1;
        int high = M;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canNailAll(A, B, sortedNails, mid, nailPositions)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canNailAll(int[] A, int[] B, List<int[]> sortedNails, int J, int[] nailPositions) {
        // Collect all nail positions from first J nails (index < J), but sorted by position
        // We use the pre-sorted list and filter by original index < J
        List<Integer> availablePositions = new ArrayList<>();
        for (int[] nail : sortedNails) {
            if (nail[1] < J) { // original index < J
                availablePositions.add(nail[0]);
            }
        }

        // If no nails available
        if (availablePositions.isEmpty()) return false;

        // Convert to array for binary search
        int[] arr = availablePositions.stream().mapToInt(i -> i).toArray();

        // Check each plank
        for (int k = 0; k < A.length; k++) {
            int start = A[k];
            int end = B[k];

            // Binary search: find if any nail in [start, end]
            int left = 0;
            int right = arr.length - 1;
            boolean found = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] >= start && arr[mid] <= end) {
                    found = true;
                    break;
                } else if (arr[mid] < start) {
                    left = mid + 1;
                } else { // arr[mid] > end
                    right = mid - 1;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NailingPlanksYoutube solution = new NailingPlanksYoutube();
        int [] A = {1, 4, 5, 8};
        int [] B = {4, 5, 9, 10};
        int [] C = {4, 6, 7, 10, 2};

        int minNumOfNails = solution.solution(A, B, C);

        System.out.println("minNumOfNails==>" + minNumOfNails);

    }
}


//This solution has a time complexity of O((N+M) + (N+M) * log(M)),
// which is more efficient than the previous solution for larger datasets.