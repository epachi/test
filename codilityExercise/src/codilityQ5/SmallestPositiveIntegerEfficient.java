package codilityQ5;

public class SmallestPositiveIntegerEfficient {

    public static void main(String[] args) {
        int[] A1 = {1, 3, 6, 4, 1, 2};
        int result1 = solution(A1);
        System.out.println("Smallest positive integer: " + result1);

        int[] A2 = {1, 2, 3};

        int result2 = solution(A2);
        System.out.println("Smallest positive integer: " + result2);

        int[] A3 = {-1, -3};
        int result3 = solution(A3);
        System.out.println("Smallest positive integer: " + result3);
    }

    public static int solution(int[] A) {
        int N = A.length;

        // Rearrange array elements to place A[i] at index i+1
        for (int i = 0; i < N; i++) {
            while (A[i] > 0 && A[i] <= N && A[A[i] - 1] != A[i]) {
                // Swap A[i] with A[A[i] - 1]
                int temp = A[i];
                A[i] = A[A[i] - 1];
                A[temp - 1] = temp;
            }
        }

        // Find the first mismatch and return the smallest positive integer not present
        for (int i = 0; i < N; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        // If all elements are in order, the smallest missing positive is N + 1
        return N + 1;
    }
}

//    This solution modifies the input array in-place, and it efficiently finds the smallest positive integer not present.
//        The time complexity is O(N), and the space complexity is O(1).

