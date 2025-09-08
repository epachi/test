package lesson3.easy;

//To achieve better performance, you can use the XOR operation.
// XORing all the elements in the expected range [1, N+1] with the elements in the array will result in the missing element.
// This approach has a time complexity of O(N) and a space complexity of O(1). Here's the Java implementation
public class PermMissingElemEfficient {
    public int solution(int[] A) {
        int N = A.length;
        // Initialize the result with the last element in the expected range
        int result = N + 1;

        // XOR all elements in [1, N+1] with elements in the array
        for (int i = 0; i < N; i++) {
            result ^= (i + 1) ^ A[i];                       //<=== result ^= (i + 1) ^ A[i];
        }

        // The result now contains the missing element
        return result;
    }

    public static void main(String[] args) {
        PermMissingElemEfficient solution = new PermMissingElemEfficient();
        int [] input = { 2, 3, 1, 5, 9, 4, 8, 6};

        System.out.println(solution.solution(input));
    }
}

//    This solution XORs all elements in the expected range with the elements in the array,
//    canceling out the paired elements and leaving only the missing element.