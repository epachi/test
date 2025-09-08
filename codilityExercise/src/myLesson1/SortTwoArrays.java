package myLesson1;

import java.util.*;

//I have two integer array A and B of size 1000.
//I would like to sort B in ascending order and at the same time the corresponding element
//in A with the same index keep in sync with the new position of B

public class SortTwoArrays {
    public static void main(String[] args) {
        Integer[] A = {10, 20, 30, 40, 50};
        Integer[] B = {5, 2, 8, 1, 9};

        // Create list of indices
        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) indices[i] = i;

        // Sort indices by B
        Arrays.sort(indices, (i, j) -> Integer.compare(B[i], B[j]));

        // Reorder A and B
        Integer[] A_sorted = new Integer[A.length];
        Integer[] B_sorted = new Integer[B.length];
        for (int i = 0; i < indices.length; i++) {
            A_sorted[i] = A[indices[i]];
            B_sorted[i] = B[indices[i]];
        }

        // Copy back
        System.arraycopy(A_sorted, 0, A, 0, A.length);
        System.arraycopy(B_sorted, 0, B, 0, B.length);

        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
    }
}