package lesson5.Easy;

//The provided solution is already quite efficient with a time complexity of O(N),
// which is optimal for this problem. However, you can make a small optimization by using a long variable to track passing pairs,
// which would allow you to avoid the check for exceeding the limit in each iteration.
// This way, you can handle larger inputs more efficiently. Here's the modified Java implementation:
public class PassingCarsEfficient {
    public int solution(int[] A) {
        int eastCars = 0;
        long passingPairs = 0;

        for (int car : A) {
            if (car == 0) {
                eastCars++;
            } else {
                passingPairs += eastCars;
            }
        }

        return (passingPairs > 1_000_000_000) ? -1 : (int) passingPairs;
    }


    public static void main(String[] args) {
        PassingCarsEfficient solution = new PassingCarsEfficient();
        int [] A = {0, 1, 0, 1, 1};

        System.out.println(solution.solution(A));
    }
}
//This change utilizes a long variable (passingPairs) instead of an int to accumulate the passing pairs.
// The final result is cast to an int before returning, and the limit check is done only once after the loop.
// This modification won't affect the time complexity but might be more efficient for larger inputs.