package codilityQ3;
//An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
//        The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
//        Write a Java function:
//        int [] solution (int [] A, int k);
//        that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
//        For example, given
//        A = [3, 8, 9, 7, 6]
//        K = 3
//        the function should return [9, 7, 6, 3, 8]. Three rotations were made:
//        [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
//        [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
//        [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
//        For another example, given
//        A = [0, 0, 0]
//        K = 1
//
//        the function should return [0, 0, 0]
public class ArrayRotation {
    public static void main(String[] args) {
        int[] A1 = {3, 8, 9, 7, 6};
        int K1 = 3;
        int[] result1 = solution(A1, K1);
        printArray(result1);

        int[] A2 = {0, 0, 0};
        int K2 = 1;
        int[] result2 = solution(A2, K2);
        printArray(result2);
    }

    public static int[] solution(int[] A, int K) {
        int N = A.length;

        if (N == 0) {
            return A; // No rotation needed for an empty array
        }

        K = K % N; // To handle cases where K is greater than the array length

        // If no rotation needed, return the original array
        if (K == 0) {
            return A;
        }

        // Create a new array to store the rotated elements
        int[] rotatedArray = new int[N];

        // Copy the rotated elements to the new array
        for (int i = 0; i < N; i++) {
            int newPosition = (i + K) % N;
            rotatedArray[newPosition] = A[i];
        }

        return rotatedArray;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

//    This Java function calculates the effective rotation count by taking the remainder when dividing K by the array length.
//        It then creates a new array to store the rotated elements, copying each element to its final position in the rotated array.
//        The example usage at the end demonstrates how to use the function with the provided test cases.
