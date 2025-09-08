package lesson12.easy;

//Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.
//
//You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
//
//You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.
//
//More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).
//
//You stop eating when you encounter an empty wrapper.
//
//For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
//
//The goal is to count the number of chocolates that you will eat, following the above rules.
//
//Write a function:
//
//class Solution { public int solution(int N, int M); }
//
//that, given two positive integers N and M, returns the number of chocolates that you will eat.
//
//For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N and M are integers within the range [1..1,000,000,000].



//To solve this problem, you can use the concept of finding the greatest common divisor (GCD) of N and M.
//        The number of chocolates you will eat is equal to N divided by the GCD of N and M.
//
//        Here's the Java code for the solution:



public class ChocolatesByNumbers {
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

//This solution uses the Euclidean algorithm to find the GCD of N and M, and then calculates the number of chocolates you will eat as N divided by the GCD.
//
//The time complexity of this solution is O(log(min(N, M))), making it efficient for the given constraints.