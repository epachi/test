package exercise2.hard;
//A company of dwarfs is travelling across the New Zealand. On reaching the Clutha River the dwarfs need to get across,
// but recent storms have washed away the bridge. Luckily, a small ferry, in the form of a square raft, is operating.
//
//        The raft is square and has N rows of seats, numbered from 1 to N. Each row contains N seats, labeled with consecutive letters (A, B, C, etc.). Each seat is identified by a string composed of its row number followed by its column number; for example, "9C" denotes the third seat in the 9th row.
//
//        The raft has already been loaded with barrels in some seat positions, and other seats are already occupied by dwarfs. Our company of dwarfs may only take the remaining unoccupied seats. The ferryman wants to accommodate as many dwarfs as possible, but the raft needs to be stable when making the crossing. That is, the following conditions must be satisfied:
//
//        the front and back halves of the raft (in terms of the rows of seats) must each contain the same number of dwarfs;
//        similarly, the left and right sides of the raft (in terms of the columns of seats) must each contain the same number of dwarfs.
//        You do not have to worry about balancing the barrels; you can assume that their weights are negligible.
//
//        For example, a raft of size N = 4 is shown in the following illustration:
//
//
//
//        Barrels are marked as brown squares, and seats that are already occupied by dwarfs are labeled d.
//
//        The positions of the barrels are given in string S. The occupied seat numbers are given in string T. The contents of the strings are separated by single spaces and may appear in any order. For example, in the diagram above, S = "1B 1C 4B 1D 2A" and T = "3B 2D".
//
//        In this example, the ferryman can accommodate at most six more dwarfs, as indicated by the green squares in the following diagram:
//
//
//
//        The raft is then balanced: both left and right halves have the same number of dwarfs (four), and both front and back halves have the same number of dwarfs (also four).
//
//        Write a function:
//
//class Solution { public int solution(int N, String S, String T); }
//
//that, given the size of the raft N and two strings S, T that describes the positions of barrels and occupied seats, respectively, returns the maximum number of dwarfs that can fit on the raft. If it is not possible to balance the raft with dwarfs, your function should return -1.
//
//        For instance, given N = 4, S = "1B 1C 4B 1D 2A" and T = "3B 2D", your function should return 6, as explained above.
//
//        Assume that:
//
//        N is an even integer within the range [2..26];
//        strings S, T consist of valid seat numbers, separated with spaces;
//        each seat number can appear no more than once in the strings;
//        no seat number can appear in both S and T simultaneously.
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
//To solve this problem, you can follow these steps:
//
//        Create a 2D array to represent the raft with N rows and N columns.
//        Mark the positions of barrels in the array.
//        Mark the positions of occupied seats in the array.
//        Calculate the number of dwarfs on the left and right halves as well as the front and back halves of the raft.
//        Check if it is possible to add dwarfs to balance the raft.
//        If it is possible, calculate the maximum number of dwarfs that can fit on the raft.

public class DwarfsRafting {
    public int solution(int N, String S, String T) {
        char[][] raft = new char[N][N];

        // Mark positions of barrels
        markPositions(raft, S, 'b');

        // Mark positions of occupied seats
        markPositions(raft, T, 'd');

        // Calculate the number of dwarfs on the left and right halves, and front and back halves
        int leftDwarfs = countDwarfs(raft, 0, N / 2, 0, N);
        int rightDwarfs = countDwarfs(raft, N / 2, N, 0, N);
        int frontDwarfs = countDwarfs(raft, 0, N, 0, N / 2);
        int backDwarfs = countDwarfs(raft, 0, N, N / 2, N);

        // Check if it is possible to balance the raft
        if (leftDwarfs != rightDwarfs || frontDwarfs != backDwarfs) {
            return -1;
        }

        // Calculate the maximum number of dwarfs that can fit on the raft
        int remainingDwarfs = (N * N - S.split(" ").length) - leftDwarfs;
        return Math.min(leftDwarfs, remainingDwarfs);
    }

    private void markPositions(char[][] raft, String positions, char mark) {
        String[] positionArray = positions.split(" ");
        for (String position : positionArray) {
            int row = Integer.parseInt(position.substring(0, position.length() - 1)) - 1;
            int col = position.charAt(position.length() - 1) - 'A';
            raft[row][col] = mark;
        }
    }

    private int countDwarfs(char[][] raft, int startRow, int endRow, int startCol, int endCol) {
        int count = 0;
        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {
                if (raft[row][col] == 'd') {
                    count++;
                }
            }
        }
        return count;
    }
}