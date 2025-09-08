package lesson1.easy;

public class BinaryGapEfficient {

    public static void main(String[] args) {
        int result1 = findLongestBinaryGap(1041);
        System.out.println("Result for N = 1041: " + result1);

        int result2 = findLongestBinaryGap(32);
        System.out.println("Result for N = 32: " + result2);
    }

    public static int findLongestBinaryGap(int N) {
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        while (N > 0) {
            int remainder = N % 2;
            N /= 2;

            if (remainder == 1) {
                if (counting) {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                } else {
                    counting = true;
                }
            } else if (counting) {
                currentGap++;
            }
        }

        return maxGap;
    }
}

