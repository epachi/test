package exercise3.medium;

//Bob is about to go on a trip. But first he needs to take care of his supply of socks. Each sock has its own color.
// Bob wants to take as many pairs of clean socks as possible (both socks in the pair should be of the same color).
//
//        Socks are divided into two drawers: clean and dirty socks.
//        Bob has time for only one laundry and his washing machine can clean at most K socks.
//        He wants to pick socks for laundering in such a way that after washing he will have a maximal number of clean,
//        same-colored pairs of socks. It is possible that some socks cannot be paired with any other sock,
//        because Bob may have lost some socks over the years.
//
//        Bob has exactly N clean and M dirty socks, which are described in arrays C and D, respectively.
//        The colors of the socks are represented as integers (equal numbers representing identical colors).
//
//        For example, given four clean socks and five dirty socks:
//
//
//
//        If Bob's washing machine can clean at most K = 2 socks, then he can take a maximum of three pairs of clean socks.
//        He can wash one red sock and one green sock, numbered 1 and 2 respectively.
//        Then he will have two pairs of red socks and one pair of green socks.
//
//        Write a function:
//
//class Solution { public int solution(int K, int[] C, int[] D); }
//
//that, given an integer K (the number of socks that the washing machine can clean), two arrays C and D (containing the color
// representations of N clean and M dirty socks respectively), returns the maximum number of pairs of socks that Bob can take on the trip.
//
//        For example, given K = 2, C = [1, 2, 1, 1] and D = [1, 4, 3, 2, 4], the function should return 3, as explained above.
//
//        Assume that:
//
//        K is an integer within the range [0..50];
//        each element of arrays C and D is an integer within the range [1..50];
//        C and D are not empty and each of them contains at most 50 elements.
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

//To solve this problem, we can simulate the process of selecting socks for laundering and pairing them up to form pairs.
//        We can use a HashMap to keep track of the count of each color in both clean and dirty socks. We iterate through the clean socks,
//        adding them to the HashMap and counting the pairs. Then, we iterate through the dirty socks, completing the pairs using the available clean socks.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SocksLaundering {
    public void printNewSet(Set<Integer> cSet){
        System.out.print("new set is:");
        for (int cc: cSet) {
            System.out.print(":"+cc);
        }
        System.out.println();
    }
    public int solution(int K, int[] C, int[] D) {
        int cleanPairCount = 0;
        Set<Integer> oddCleanSockSet = new HashSet<>();
        for (int c: C) {
            System.out.println("new input is:"+c);
            if (oddCleanSockSet.contains(c)) {
                cleanPairCount++;
                oddCleanSockSet.remove(c);
                printNewSet(oddCleanSockSet);
            } else {
                oddCleanSockSet.add(c);
                printNewSet(oddCleanSockSet);
            }
        }

        System.out.println("cleanPairCount: "+ cleanPairCount);
        for (int c: oddCleanSockSet) {
            System.out.print(":"+c);
        }


        int numberOfSockToBeCleaned = K;
        if (numberOfSockToBeCleaned == 0) {
            return cleanPairCount;
        }

        Set<Integer> oddDirtySockSet = new HashSet<>();
        Set<Integer> pairDirtySocket = new HashSet<>();

        // Sort the dirty socks
        // First check with the oddCleanSockSet, if found, clean it.
        //      if no match, put it into oddDirtySocket set and pairDirtySocket set
        for (int d: D) {
            if (oddCleanSockSet.contains(d)) {
                //Clean it first
                cleanPairCount++;
                numberOfSockToBeCleaned--;
                if (numberOfSockToBeCleaned == 0) {
                    System.out.println("\n****cleanPairCount:"+cleanPairCount+"\n");
                    return cleanPairCount;
                }
            } else {
                if (oddDirtySockSet.contains(d)) {
                    oddDirtySockSet.remove(d);
                    pairDirtySocket.add(d);
                } else {
                    oddDirtySockSet.add(d);
                }
            }
        }

        System.out.println("!!!! BEFORE CLEANING !!!");
        System.out.println("cleanPairCount:"+ cleanPairCount);
        System.out.println("numberOfSockToBeCleaned:"+ numberOfSockToBeCleaned);
        System.out.println("pairDirtySocket.size():"+ pairDirtySocket.size());

        cleanPairCount += Integer.min(numberOfSockToBeCleaned/2, pairDirtySocket.size());
        System.out.println("****cleanPairCount"+cleanPairCount);
        return cleanPairCount;

    }
//    public int solution(int K, int[] C, int[] D) {
//        HashMap<Integer, Integer> cleanSockCounts = new HashMap<>();
//        HashMap<Integer, Integer> dirtySockCounts = new HashMap<>();
//
//        int pairsCount = 0;
//
//        // Process clean socks
//        for (int color : C) {
//            cleanSockCounts.put(color, cleanSockCounts.getOrDefault(color, 0) + 1);
//            if (cleanSockCounts.get(color) % 2 == 0) {
//                pairsCount++;
//            }
//        }
//
//        // Process dirty socks and complete pairs using clean socks
//        for (int color : D) {
//            dirtySockCounts.put(color, dirtySockCounts.getOrDefault(color, 0) + 1);
//
//            if (dirtySockCounts.get(color) % 2 == 0) {
//                pairsCount++;
//            } else if (cleanSockCounts.containsKey(color) && cleanSockCounts.get(color) > 0) {
//                cleanSockCounts.put(color, cleanSockCounts.get(color) - 1);
//                pairsCount++;
//            }
//        }
//
//        // Use at most K socks for laundering
//        int remainingPairs = K / 2;
//        pairsCount += Math.min(remainingPairs, cleanSockCounts.size());
//
//        return pairsCount;
//    }

    public static void main(String[] args) {
        SocksLaundering solution = new SocksLaundering();
//        int K = 2;
        int[] C = {1, 2, 1, 1};
        int[] D = {1, 4, 3, 2, 4};

//        System.out.println(solution.solution(2, C, D)); // Output: 3

        System.out.println("!!!! SECOND RUN");
        System.out.println(solution.solution(3, C, D));   // Output: 3

    }
}

//    This solution maintains counts of clean and dirty socks using HashMaps.
//        It iterates through the clean socks to count pairs and then processes the dirty socks, completing pairs using the available clean socks.
//        Finally, it uses at most K socks for laundering,
//        considering half of them will form pairs. The pairsCount variable is updated accordingly and returned as the result.