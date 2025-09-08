package codilityQ8;
import java.util.Arrays;
public class TriangularTripletEfficient {

    public static void main(String[] args) {
        int[] A1 = {10, 2, 5, 1, 8, 20};
        int result1 = solution(A1);
        System.out.println("Exists a triangular triplet? " + result1);

        int[] A2 = {10, 50, 5, 1};
        int result2 = solution(A2);
        System.out.println("Exists a triangular triplet? " + result2);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Check if there are less than 3 elements in the array
        if (N < 3) {
            return 0; // Not enough elements for a triangular triplet
        }

        // Sort the array in non-decreasing order
        Arrays.sort(A);                                     // <=== Arrays.sort(A)

        // Iterate through the array to check for triangular triplets
        for (int i = 0; i < N - 2; i++) {
            long P = A[i];
            long Q = A[i + 1];
            long R = A[i + 2];

            // Check the triangular condition
            if (P + Q > R) {
                return 1; // Triangular triplet found
            }
        }

        return 0; // No triangular triplet found
    }
}
