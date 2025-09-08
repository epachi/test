package exercise9BitwiseOperations.easy;

//A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded
// by ones at both ends in the binary representation of N.
//
//        For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
//        The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
//
//        Write a function:
//
//class Solution { public int solution(int N); }
//
//that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
//
//        For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..2,147,483,647].
public class BinaryGap {

    public static void main(String[] args) {

        System.out.println("Result for N = 529: " + solution(529));

        System.out.println("Result for N = 20: " + solution(20));

        System.out.println("Result for N = 15: " + solution(15));

        System.out.println("Result for N = 1041: " + solution(1041));

        System.out.println("Result for N = 32: " + solution(32));
    }

    public static int solution(int N) {
        String binaryRepresentation = Integer.toBinaryString(N);

        int maxGap = 0;
        int currentGap = 0;
        boolean countingZeros = false;

        for (char digit : binaryRepresentation.toCharArray()) {
            if (digit == '1') {
                if (countingZeros) {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                }
                countingZeros = true;
            } else {
                if (countingZeros) {
                    currentGap++;
                }
            }
        }

        return maxGap;
    }
}

//    This solution converts the given integer N to its binary representation using Integer.toBinaryString(N).
//    It then iterates through each digit of the binary representation,
//    keeping track of the current binary gap length and the maximum binary gap encountered so far.
//
//        The algorithm uses a boolean variable countingZeros to determine whether
//        it should increment the current binary gap length or not. When a '1' is encountered,
//        it updates the maximum binary gap if needed and resets the current gap length. The final result is the length of the longest binary gap.
//
//        This algorithm has a time complexity of O(log N) due to the conversion to binary representation.
