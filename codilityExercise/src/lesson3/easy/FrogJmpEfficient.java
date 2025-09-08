package lesson3.easy;

//
//The provided solution is already efficient with a time complexity of O(1), as it performs a constant number of arithmetic operations regardless of the input size.
//        However, you can simplify the code and avoid the conditional statement. Here's an updated version:
public class FrogJmpEfficient {
    public int solution(int X, int Y, int D) {
        int distanceToCover = Y - X;
        return (distanceToCover + D - 1) / D;
    }
}

//This version uses integer division to calculate the number of jumps required.
// Adding D - 1 to distanceToCover before division ensures that the result is rounded up to the nearest integer,
// effectively handling the case when there is a remainder.
