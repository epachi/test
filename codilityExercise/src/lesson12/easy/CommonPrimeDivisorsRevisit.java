package lesson12.easy;


//A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
//
//A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.
//
//You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.
//
//For example, given:
//
//N = 15 and M = 75, the prime divisors are the same: {3, 5};
//N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
//N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.
//Write a function:
//
//class Solution { public int solution(int[] A, int[] B); }
//
//that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.
//
//For example, given:
//
//    A[0] = 15   B[0] = 75
//    A[1] = 10   B[1] = 30
//    A[2] = 3    B[2] = 5
//the function should return 1, because only one pair (15, 75) has the same set of prime divisors.
//
//Write an efficient algorithm for the following assumptions:
//
//Z is an integer within the range [1..6,000];
//each element of arrays A and B is an integer within the range [1..2,147,483,647].

//To solve this problem, we can use the greatest common divisor (GCD) to find the common prime divisors between two numbers.
// If the GCD of A[K] and B[K] is equal to 1, it means they have no common prime divisors.
// Otherwise, we need to check if the common prime divisors between A[K] and B[K] are the same for both numbers.
public class CommonPrimeDivisorsRevisit {
    public int solution(int[] A, int[] B) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                result++;
            }
        }

        return result;
    }

    // Examine the test data to get insight of the algorithm.
    private boolean hasSamePrimeDivisors(int a, int b) {
        int gcdValue = gcd(a, b);

        while (a != 1) {
            int gcdA = gcd(a, gcdValue);
            if (gcdA == 1) {
                break;
            }
            a /= gcdA;
        }

        while (b != 1) {
            int gcdB = gcd(b, gcdValue);
            if (gcdB == 1) {
                break;
            }
            b /= gcdB;
        }

        return a == 1 && b == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        CommonPrimeDivisorsRevisit solution = new CommonPrimeDivisorsRevisit();
        int [] A= { 15, 10, 3, 24};
        int [] B= { 75, 30, 5, 54};


        int numOfPairs = solution.solution(A, B);
        System.out.println("==>" + numOfPairs);

    }
}


//This solution uses the Euclidean algorithm for finding the GCD and then checks if the common prime divisors are the same for both numbers.
// The time complexity is O(Z * log(max(A[i], B[i]))) where Z is the length of arrays A and B.