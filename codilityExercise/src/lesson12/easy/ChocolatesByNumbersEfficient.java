package lesson12.easy;


//Certainly! We can optimize the solution by using the mathematical property that the number of chocolates
// you will eat is equal to the least common multiple (LCM) of N and M divided by M.
//
//Here's the more efficient Java code:



public class ChocolatesByNumbersEfficient {
    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    // Recursive function to find the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

//In this optimized version, we use the fact that LCM(N, M) = N * M / GCD(N, M).
// Since we are only interested in the number of chocolates eaten, we divide N by the GCD of N and M, which is equivalent to LCM(N, M) / M.
//
//This solution maintains the same time complexity of O(log(min(N, M))), but it is more efficient in terms of simplicity and avoiding unnecessary computations.