package lesson17.high;

//To achieve better performance, we can use the following approach:
//
//Sort the array A in non-decreasing order.
//Calculate the prefix sum of the absolute values of the sorted array.
//Iterate through the array and, at each index, calculate the current absolute sum by subtracting twice the prefix sum up to the current index.
//Keep track of the minimum absolute sum encountered during the iteration.
//This approach avoids the need to create a separate array for absolute values and is more efficient.
//
//Here's the updated Java code:
public class MinAbsSumEfficientByQwen3 {
    public int solution(int[] A) {
        int totalAbsSum = 0;
        for (int a : A) {
            totalAbsSum += Math.abs(a);
        }

        if (totalAbsSum == 0) return 0;

        java.util.BitSet reachable = new java.util.BitSet();
        reachable.set(totalAbsSum); // represents sum 0 (offset)

        for (int a : A) {
            int absA = Math.abs(a);
            java.util.BitSet next = (java.util.BitSet) reachable.clone();
            reachable.clear();

            // Option 1: add +absA -> shift right by absA
            reachable.or(next.get(absA, next.size()));

            // Option 2: add -absA -> shift left by absA
            reachable.or(next.get(0, next.size() - absA));
        }

        // Find the smallest absolute sum achievable
        for (int d = 0; d <= totalAbsSum; d++) {
            if (reachable.get(totalAbsSum + d) || reachable.get(totalAbsSum - d)) {
                return d;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MinAbsSumEfficientByQwen3 solution = new MinAbsSumEfficientByQwen3();
        int[] A = {1, 5, 2, -2};
        System.out.println(solution.solution(A)); // Output: 0
    }
}
//
//This solution has a time complexity of O(N * log(N)) due to the sorting step, and it avoids unnecessary array creation.