package exercise5CodingSkills.easy;

//A positive integer N is given. The goal is to find the highest power of 2 that divides N. In other words,
// we have to find the maximum K for which N modulo 2^K is 0.
//
//        For example, given integer N = 24 the answer is 3, because 2^3 = 8 is the highest power of 2 that divides N.
//
//        Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a positive integer N, returns the highest power of 2 that divides N.
//
//        For example, given integer N = 24, the function should return 3, as explained above.
//
//        Assume that:
//
//        N is an integer within the range [1..1,000,000,000].
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
//
//To find the highest power of 2 that divides a positive integer N, you can count the number of trailing zeros in the binary representation of N.
//        The number of trailing zeros is equal to the highest power of 2 that divides N. Here's a Java implementation:
public class ParityDegree {
    public int solution(int N) {
        // Count the number of trailing zeros
        int count = 0;

        // Keep shifting N to the right until the least significant bit is 1
        while ((N & 1) == 0) {                              //<=== (N & 1) == 0
            N >>= 1; // Right shift by 1                    //<=== N >>= 1
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        ParityDegree solution = new ParityDegree();
        System.out.println(solution.solution(24)); // Output: 3
        System.out.println(solution.solution(32)); // Output: 5
        System.out.println(solution.solution(7));  // Output: 0
    }
}
//In this solution, the solution method counts the number of trailing zeros by repeatedly right-shifting N until the least significant bit is 1.
//        The count represents the highest power of 2 that divides N.