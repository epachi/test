package exercise9BitwiseOperations.easy;

public class BinaryGapEfficient {
    public int solution(int N) {
        int maxGap = 0;
        int currentGap = 0;
        boolean countingZeros = false;

        // Iterate through each bit of the binary representation
        while (N > 0) {
            int remainder = N % 2;

            if (remainder == 1) {
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

            N /= 2;
        }

        return maxGap;
    }
}

//In this implementation,
//        we directly iterate through each bit of the binary representation of the integer without converting it to a binary string.
//        The algorithm uses bitwise operations to check the least significant bit (remainder of division by 2) and updates the binary gap accordingly.
//
//        This approach is more efficient in terms of both time and space complexity compared to the previous solution that involved converting the integer to a binary string.
