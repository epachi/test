package lesson11.medium;

//Certainly! We can optimize the solution by avoiding redundant calculations and improving the efficiency of finding divisors. Here's an updated solution:
//


import java.util.HashMap;

public class CountNonDivisibleEfficientRevisit {
    public int[] solution(int[] A) {
        int N = A.length;
        int[] result = new int[N];

        // Count occurrences of each number in A
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int num : A) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < N; i++) {
            int num = A[i];
            int count = 0;

            // Iterate through divisors
            for (int divisor = 1; divisor * divisor <= num; divisor++) {     /// <=====divisor * divisor <= num condition in loop
                if (num % divisor == 0) {
                    count += occurrences.getOrDefault(divisor, 0);
                    if (num / divisor != divisor) {
                        count += occurrences.getOrDefault(num / divisor, 0);
                    }
                }
            }

            // Subtract occurrences of the number itself
            result[i] = N - count;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNonDivisible solution = new CountNonDivisible();
        int [] input = { 3, 1, 2, 3, 6};
        int [] nonDivisorCount = solution.solution(input);

        for (int i = 0 ; i < input.length ; i++) {
            System.out.println("-->" + nonDivisorCount[i]);

        }
    }
}
// In this version, we only iterate up to the square root of the number to find divisors.
// Also, we handle the case where the divisor and its complement are the same (perfect squares).
// This optimization helps to reduce the overall time complexity of the solution.