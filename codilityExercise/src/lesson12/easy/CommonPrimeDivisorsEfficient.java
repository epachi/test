package lesson12.easy;


//To achieve a more efficient solution, we can improve the algorithm by using the fact that if two numbers
// have the same set of prime divisors,
// their greatest common divisor (GCD) should be a number composed of only those prime divisors.
public class CommonPrimeDivisorsEfficient {
    public int solution(int[] A, int[] B) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                result++;
            }
        }

        return result;
    }

    private boolean hasSamePrimeDivisors(int a, int b) {
        int gcdValue = gcd(a, b);

        // Check if the prime divisors of a are the same as the ones in gcdValue
        while (a != 1) {
            int gcdA = gcd(a, gcdValue);
            if (gcdA == 1) {
                break;
            }
            a /= gcdA;
        }

        if (a != 1) {
            return false;
        }

        // Check if the prime divisors of b are the same as the ones in gcdValue
        while (b != 1) {
            int gcdB = gcd(b, gcdValue);
            if (gcdB == 1) {
                break;
            }
            b /= gcdB;
        }

        return b == 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

//This optimized solution avoids unnecessary calculations and has a similar time complexity to the previous one,
// but with potentially faster execution in practice.
// The time complexity is still O(Z * log(max(A[i], B[i]))) where Z is the length of arrays A and B.