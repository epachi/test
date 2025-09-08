package exercise7DataStructure.easy;

import java.util.HashSet;

//The provided solution is already quite efficient, with a time complexity of O(N) where N is the length of the array A.
//        This is because it traverses the list exactly once, updating the current index until it reaches the end.
//
//        Since the problem requires simulating the construction of the linked list, there is not much room for further optimization in terms of time complexity.
//        However, if you're looking to optimize for space, you could consider using a HashSet to keep track of visited indices.
//        This would allow you to detect cycles in the linked list (if any) and handle cases where the list is not a valid linked list.
public class ArrListLenEfficient {
    public int solution(int[] A) {
        HashSet<Integer> visited = new HashSet<>();
        int length = 0;
        int current = 0;

        while (current != -1 && !visited.contains(current)) {
            visited.add(current);
            current = A[current];
            length++;
        }

        return (current == -1) ? length : -1; // Return -1 if there is a cycle in the list
    }
}
//In this version, the HashSet is used to keep track of visited indices.
//        If the current index is revisited during the traversal, it means there is a cycle, and the function returns -1.
//        Otherwise, it returns the length of the list.
//
//        Keep in mind that this added check for cycles increases the space complexity to O(N) in the worst case.
//        The trade-off here is better handling of cases where the input array does not represent a valid linked list.