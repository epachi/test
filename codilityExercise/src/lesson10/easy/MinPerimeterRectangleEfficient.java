package lesson10.easy;

//To further optimize the solution, you can observe that when you find one factor of N, you also find its corresponding factor.
// Thus, you only need to iterate up to the square root of N and consider both factors at the same time. Here's an updated version of the solution:


public class MinPerimeterRectangleEfficient {
    public int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;

        // Iterate through potential factors up to the square root of N
        for (int i = 1; (long) i * i <= N; i++) {
            if (N % i == 0) {
                // Found a pair of factors (i, N/i)
                int factor1 = i;
                int factor2 = N / i;

                // Calculate perimeter for the current pair of factors
                int perimeter = 2 * (factor1 + factor2);

                // Update the minimum perimeter if the current one is smaller
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }
}


//This approach still has a time complexity of O(sqrt(N)), but it performs better since it considers both factors simultaneously.
// The (long) casting is used to handle cases where i * i might exceed the range of int.