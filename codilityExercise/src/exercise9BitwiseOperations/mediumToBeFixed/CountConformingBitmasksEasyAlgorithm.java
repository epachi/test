package exercise9BitwiseOperations.mediumToBeFixed;

//In this problem we consider unsigned 30-bit integers, i.e. all integers B such that 0 ≤ B < 2^30.
//
//        We say that integer A conforms to integer B if, in all positions where B has bits set to 1, A has corresponding bits set to 1.
//
//        For example:
//
//        00 0000 1111 0111 1101 1110 0000 1111(BIN) = 16244239 conforms to
//        00 0000 1100 0110 1101 1110 0000 0001(BIN) = 13032961, but
//        11 0000 1101 0111 0000 1010 0000 0101(BIN) = 819399173 does not conform to
//        00 0000 1001 0110 0011 0011 0000 1111(BIN) = 9843471.
//        Write a function:
//
//class Solution { public int solution(int A, int B, int C); }
//
//that, given three unsigned 30-bit integers A, B and C, returns the number of unsigned 30-bit integers conforming
// to at least one of the given integers.
//
//        For example, for integers:
//
//        A = 11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1073741727,
//        B = 11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1073741631, and
//        C = 11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1073741679,
//        the function should return 8, since there are 8 unsigned 30-bit integers conforming to A, B or C, namely:
//
//        11 1111 1111 1111 1111 1111 0011 1111(BIN) = 1073741631,
//        11 1111 1111 1111 1111 1111 0110 1111(BIN) = 1073741679,
//        11 1111 1111 1111 1111 1111 0111 1111(BIN) = 1073741695,
//        11 1111 1111 1111 1111 1111 1001 1111(BIN) = 1073741727,
//        11 1111 1111 1111 1111 1111 1011 1111(BIN) = 1073741759,
//        11 1111 1111 1111 1111 1111 1101 1111(BIN) = 1073741791,
//        11 1111 1111 1111 1111 1111 1110 1111(BIN) = 1073741807,
//        11 1111 1111 1111 1111 1111 1111 1111(BIN) = 1073741823.
//        Write an efficient algorithm for the following assumptions:
//
//        A, B and C are integers within the range [0..1073741823].



//        Certainly! To solve this problem efficiently, you can use bitwise operations to count the number of positions
//        where at least one of the given integers A, B, or C has a bit set to 1.
//        The count will give you the number of unsigned 30-bit integers conforming to at least one of the given integers.

public class CountConformingBitmasksEasyAlgorithm {
    // From ChatGPT (Wrong solution)
//    public static int solution(int A, int B, int C) {
//        // Find the common set bits in A, B, and C
//        int commonBits = A & B & C;
//
//        // Count the number of set bits in commonBits
//        int count = 0;
//        while (commonBits != 0) {
//            // Increment count if the least significant bit is 1
//            count += commonBits & 1;
//            // Shift commonBits to the right
//            commonBits >>= 1;
//        }
//
//        // Calculate the number of conforming integers
//        int conformingIntegers = 1 << count;
//        return conformingIntegers;
//    }

    // From ClaudAI
//    The key idea is:
//
//        Loop through all possible 30-bit integers from 0 to 2^30 - 1
//        Use bitwise AND to check if current integer conforms to A, B or C
//        Increment count if current integer conforms to any of A, B or C
//        Some optimizations:
//
//        Use bit shifting (1<<30) instead of computing power of 2
//        Use bitwise AND instead of character-by-character comparison
//        Return early if count reaches 8 based on example
//        Let me know if you have any other questions!

    public static int solution(int A, int B, int C) {
        System.out.println("Solution Start");
        int count = 0;

        for (int i = 0; i < (1<<30); i++) {
            if ((i & A) == A || (i & B) == B || (i & C) == C) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        System.out.println("Main Start");
        System.out.println("Count is: " + solution(1073741727, 1073741631, 1073741679));

    }
}
//    This solution iterates through each bit position from the least significant bit to the most significant bit (30 bits for a 30-bit integer). For each position,
//        it checks whether at least one of the integers A, B, or C has a corresponding bit set to 1.
//        If true, it sets the corresponding bit in the conformingIntegers variable using bitwise OR.
//
//        The return type of the solution function is an integer representing the result in terms of a 30-bit
//        integer with the set bits in positions where at least one of A, B, or C has a bit set to 1.
//        If you need the count of such integers, you can modify the function accordingly.






