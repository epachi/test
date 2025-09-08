package exercise9BitwiseOperations.mediumToBeFixed;

//Certainly! We can optimize the solution by counting the set bits directly without using a loop.
//        This can be done by using a well-known algorithm called the Brian Kernighan's Algorithm.
//        The algorithm works by repeatedly flipping the rightmost set bit to 0 in a number.
public class CountConformingBitmasksEfficientMySolution {
    //From ChatGPT (Wrong solution)
//    public static int solution(int A, int B, int C) {
//        int bitmask = A | B | C;
//        return countSetBits(bitmask);
//    }
//
//    private static int countSetBits(int num) {
//        int count = 0;
//        while (num > 0) {
//            num &= (num - 1);
//            count++;
//        }
//        return count;
//    }

    public static int  solution(int A, int B, int C) {
        int Abits = 0;
        int Bbits = 0;
        int Cbits = 0;
        int interestingBitCount = 0;
        int bitmask = A & B & C;
//        while (bitmask > 0) {
//            System.out.println(">>" + bitmask%2);
//            bitmask = bitmask/2;
//        }

        while (bitmask > 0) {
            if (bitmask%2 == 1) {
                //We can skip that bit
            } else { //bitmask%2 == 0
                Abits = Abits * 2 + A % 2;
                System.out.println("===>"+B%2);
                Bbits = Bbits * 2 + B % 2;
                Cbits = Cbits * 2 + C % 2;
                interestingBitCount++;
            }
            A/=2;
            B/=2;
            C/=2;
            bitmask /=2;
        }

        System.out.println("Abits:"+Abits);
        System.out.println("Bbits:"+Bbits);
        System.out.println("Cbits:"+Cbits);
        System.out.println("interestingBitCount:"+interestingBitCount);
        // NOTE: Abits, Bbits and Cbits have all be reverted but it does not affect the total counts below

        int count = 0;

        for (int i = 0; i < (1<<interestingBitCount); i++) {
            if ((i & Abits) == Abits || (i & Bbits) == Bbits || (i & Cbits) == Cbits) {
                System.out.println(i);
                count++;
            }
        }

        return count;

    }



    public static void main(String[] args) {

        System.out.println("Count is: " + solution(1073741727, 1073741631, 1073741679));

    }
}

//    In the countSetBits function, the line num &= (num - 1); effectively flips the rightmost set bit to 0.
//        By repeatedly applying this operation until num becomes 0, we can count the number of set bits efficiently.
//
//        This algorithm maintains the O(log N) time complexity, where N is the maximum value of the input integers (2^30),
//        and it has a constant space complexity of O(1).







