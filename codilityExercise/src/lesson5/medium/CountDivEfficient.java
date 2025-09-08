package lesson5.medium;
//Certainly! You can solve this problem efficiently by finding the count of integers divisible by K within the range [A..B].
//        The count can be obtained using the formula (B/K) - (A/K) + (A % K == 0 ? 1 : 0).


//You can solve this problem efficiently using integer division. Here's a simple Java implementation:
public class CountDivEfficient {
    public int solution(int A, int B, int K) {
        // Count of integers divisible by K within the range [A..B]
        int count = (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
        return count;
    }
}
//
//    This solution has a time complexity of O(1) since it involves only simple arithmetic operations,
//    and the space complexity is O(1) as well.

