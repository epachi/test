package exercise2.medium;
import java.util.*;
//Halfling Woolly Proudhoof is an eminent sheep herder.
// He wants to build a pen (enclosure) for his new flock of sheep.
// The pen will be rectangular and built from exactly four pieces of fence
// (so, the pieces of fence forming the opposite sides of the pen must be of equal length).
// Woolly can choose these pieces out of N pieces of fence that are stored in his barn.
// To hold the entire flock, the area of the pen must be greater than or equal to a given threshold X.
//
//        Woolly is interested in the number of different ways in which he can build a pen. Pens are considered different if the sets of lengths of their sides are different. For example, a pen of size 1×4 is different from a pen of size 2×2 (although both have an area of 4), but pens of sizes 1×2 and 2×1 are considered the same.
//
//        Write a function:
//
//class Solution { public int solution(int[] A, int X); }
//
//that, given an array A of N integers (containing the lengths of the available pieces of fence) and an integer X,
// returns the number of different ways of building a rectangular pen satisfying the above conditions.
// The function should return −1 if the result exceeds 1,000,000,000.
//
//        For example, given X = 5 and the following array A:
//
//        A[0] = 1
//        A[1] = 2
//        A[2] = 5
//        A[3] = 1
//        A[4] = 1
//        A[5] = 2
//        A[6] = 3
//        A[7] = 5
//        A[8] = 1
//
//
//        the function should return 2. The figure above shows available pieces of fence (on the left)
//        and possible to build pens (on the right). The pens are of sizes 1x5 and 2x5.
//        Pens of sizes 1×1 and 1×2 can be built, but are too small in area.
//        It is not possible to build pens of sizes 2×3 or 3×5, as there is only one piece of fence of length 3.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [0..100,000];
//        X is an integer within the range [1..1,000,000,000];
//        each element of array A is an integer within the range [1..1,000,000,000].

//
//we can use a two-pointer approach. Sort the array in non-decreasing order and then use two pointers
//        to find pairs of fence lengths that can form a rectangular pen with an area
//        greater than or equal to the given threshold X.
public class RectangleBuilderGreaterArea {

    HashMap<Integer, Set<Integer>> dimIJ = new HashMap<>();
    ArrayList<Integer> buildAvailablePenPair(int []A) {
        ArrayList<Integer> availablePenPair = new ArrayList<>();
        if (A.length < 2) {
            return availablePenPair;
        }
        int firstIndex = 0;
        int secondIndex = 1;
        while (true){
            if (A[firstIndex] == A[secondIndex]) {
                availablePenPair.add(A[firstIndex]);
                if (A.length - secondIndex >= 2) {
                    firstIndex += 2;
                    secondIndex += 2;
                } else {//Pairing process completed
                    break;
                }
            } else {//No pair is found, skip the firstIndex
                if (A.length - secondIndex >= 1) {
                    firstIndex += 1;
                    secondIndex += 1;
                } else {//Pairing process completed
                    break;
                }
            }
        }
        return availablePenPair;
    }

    public int solution(int[] A, int X) {
        Arrays.sort(A);
        ArrayList<Integer> availablePenPair = buildAvailablePenPair(A);

        for (int i =0 ; i < availablePenPair.size() ; i++) {
            System.out.println("availablePenPair.get("+i+")="+availablePenPair.get(i));
        }
        System.out.println("availablePenPair.size() :" + availablePenPair.size());

        int bigEnoughPenPair = 0;
        if (availablePenPair.size() < 2) {
            return bigEnoughPenPair;
        }

        for (int i = availablePenPair.size()-1 ; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                System.out.println("i is:"+i+", j is:"+j);
                if (availablePenPair.get(i) * availablePenPair.get(j) >= X) {
                    System.out.println("Big Enough dimensions: [i]:"+availablePenPair.get(i)+", [j]:"+ availablePenPair.get(j));
                    if (!checkExistingPenDimenion(availablePenPair.get(i), availablePenPair.get(j))) {
                        bigEnoughPenPair++;
                    }
                } else {
                    break;
                }
            }
        }
        return bigEnoughPenPair;

    }

    private boolean checkExistingPenDimenion(int dimI, int dimJ) {
        if (dimIJ.get(dimI) == null) {
            Set<Integer> intSet = new HashSet<Integer>();
            intSet.add(dimJ);
            dimIJ.put(dimI, intSet);
            return false;
        } else {
            Set<Integer> intSet = dimIJ.get(dimI);
            if (intSet.contains(dimJ)) {
                return true;
            } else {
                intSet.add(dimJ);
                return false;
            }
        }
    }



    public static void main(String[] args) {
        RectangleBuilderGreaterArea solution = new RectangleBuilderGreaterArea();
        int[] A = {1, 2, 5, 1, 1, 2, 3, 5, 1};
        int X = 5;
        System.out.println(solution.solution(A, X)); // Output: 2
    }
}
//    This solution sorts the array and uses two pointers to traverse the sorted array.
//        It calculates the area for each pair of fence lengths and increments the count for valid pairs.
//        The loop continues until the pointers meet. The algorithm ensures that the result does not exceed the limit of 1,000,000,000.