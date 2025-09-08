package lesson10.easy;

////
//To find the minimal perimeter of a rectangle with a given area N,
//        you need to consider all possible pairs of factors of N and calculate the corresponding perimeters.
//        The idea is to find a pair (A, B) such that A * B = N and the perimeter 2 * (A + B) is minimized.
//
//        Here is the Java code for the solution:



public class MinPerimeterRectangle {
    public int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;

        // Iterate through potential factors up to the square root of N
        for (int i = 1; (long) i * i <= N; i++) {
            if (N % i == 0) {
                // Found a factor i, calculate the corresponding factor
                int factor = N / i;

                // Calculate perimeter for the current pair of factors
                int perimeter = 2 * (i + factor);

                // Update the minimum perimeter if the current one is smaller
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }
}



//This solution has a time complexity of O(sqrt(N)), as it iterates through potential factors up to the square root of N.
// The (long) casting is used to handle cases where i * i might exceed the range of int.