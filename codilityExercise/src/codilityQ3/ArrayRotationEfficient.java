public class ArrayRotationEfficient {

    public static void main(String[] args) {
        int[] A1 = {3, 8, 9, 7, 6};
        int K1 = 3;
        solution(A1, K1);
        printArray(A1);

        int[] A2 = {0, 0, 0};
        int K2 = 1;
        solution(A2, K2);
        printArray(A2);
    }

    public static void solution(int[] A, int K) {
        int N = A.length;

        if (N == 0 || K % N == 0) {
            return; // No rotation needed for an empty array or when K is a multiple of N
        }

        K = K % N; // To handle cases where K is greater than the array length

        reverseArray(A, 0, N - 1); // Reverse the entire array
        reverseArray(A, 0, K - 1); // Reverse the first K elements
        reverseArray(A, K, N - 1); // Reverse the remaining elements
    }

    public static void reverseArray(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

//    This optimized solution reverses different segments of the array to achieve the rotation in-place.
//        The solution method first reverses the entire array, then reverses the first K elements, and finally reverses the remaining elements.
//        This approach avoids the need for creating a new array, making it more memory-efficient.