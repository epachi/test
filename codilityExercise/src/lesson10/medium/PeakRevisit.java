package lesson10.medium;

//A non-empty array A consisting of N integers is given.
//
//A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,
// A[P − 1] < A[P] and A[P] > A[P + 1].
//
//For example, the following array A:
//
//    A[0] = 1
//    A[1] = 2
//    A[2] = 3
//    A[3] = 4
//    A[4] = 3
//    A[5] = 4
//    A[6] = 1
//    A[7] = 2
//    A[8] = 3
//    A[9] = 4
//    A[10] = 6
//    A[11] = 2
//has exactly three peaks: 3, 5, 10.
//
//We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K
// that will yield the following blocks:
//
//A[0], A[1], ..., A[K − 1],
//A[K], A[K + 1], ..., A[2K − 1],
//...
//A[N − K], A[N − K + 1], ..., A[N − 1].
//What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).
//
//The goal is to find the maximum number of blocks into which the array A can be divided.
//
//Array A can be divided into blocks as follows:
//
//one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
//two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
//three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
//However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].
//
//The maximum number of blocks that array A can be divided into is three.
//
//Write a function:
//
//class Solution { public int solution(int[] A); }
//
//that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.
//
//If A cannot be divided into some number of blocks, the function should return 0.
//
//For example, given:
//
//    A[0] = 1
//    A[1] = 2
//    A[2] = 3
//    A[3] = 4
//    A[4] = 3
//    A[5] = 4
//    A[6] = 1
//    A[7] = 2
//    A[8] = 3
//    A[9] = 4
//    A[10] = 6
//    A[11] = 2
//the function should return 3, as explained above.
//
//Write an efficient algorithm for the following assumptions:
//
//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [0..1,000,000,000].

//To solve this problem, you can use a binary search to find the maximum number of blocks.
// For a given number of blocks (let's call it K), you can check whether it's possible to divide the array into K blocks,
// each containing at least one peak. If it is possible, you can then try a larger value of K.
// If it's not possible, you can try a smaller value of K.
//
//Here's a Java implementation of the solution:

public class PeakRevisit {
    public int solution(int[] A) {
        int N = A.length;

        // Find peaks
        int[] peaks = new int[N];
        int peakCount = 0;
        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks[peakCount++] = i;
            }
        }

        // If there are no peaks, return 0
        if (peakCount == 0) {
            return 0;
        }
//System.out.print("Peaks: " + peaks);



        // Try different values of K using binary search
        int left = 1;
        int right = peakCount; // maximum possible value of K is the number of peaks

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(A, peaks, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right; // return the maximum number of blocks
    }

    private boolean canDivide(int[] A, int[] peaks, int K) {
        int N = A.length;
        int blocks = 0;
        int currentBlock = 0;

        for (int peak : peaks) {
            if (peak >= currentBlock * K && peak < (currentBlock + 1) * K) {
                continue;
            }

            currentBlock = peak / K;
            blocks++;

            if (blocks == K) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PeakRevisit solution = new PeakRevisit();
        int [] input = { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};

        System.out.println(solution.solution(input));
    }
}

//This solution first identifies the peaks in the array and then uses binary search to find the maximum number of blocks.
// The canDivide function checks whether it's possible to divide the array into K blocks, each containing at least one peak.