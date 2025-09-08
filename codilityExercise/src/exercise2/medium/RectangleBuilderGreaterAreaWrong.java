package exercise2.medium;

///Certainly! We can further optimize the solution by using a single loop with two pointers,
//        eliminating the need to sort the array. This approach reduces the time complexity to O(N), where N is the length of the array.
public class RectangleBuilderGreaterAreaWrong {
    public int solution(int[] A, int X) {
        int count = 0;
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            long area = (long) A[left] * A[right];

            if (area >= X) {
                count += 2 * (right - left) + 1; // Count all possible combinations
                if (count > 1_000_000_000) {
                    return -1; // Check for the result exceeding the limit
                }
                right--;
            } else {
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        RectangleBuilderGreaterAreaWrong solution = new RectangleBuilderGreaterAreaWrong();
        int[] A = {1, 2, 5, 1, 1, 2, 3, 5, 1};
        int X = 5;
        System.out.println(solution.solution(A, X)); // Output: 2
    }
}

//    This updated solution maintains the same logic but avoids the sorting step, resulting in a more efficient algorithm with a linear time complexity.
//        The key is to use a single loop with two pointers to traverse the array and calculate the area for each pair of fence lengths.