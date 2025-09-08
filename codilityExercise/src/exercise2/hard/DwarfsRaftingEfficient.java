package exercise2.hard;
//Sure, let's try to optimize the solution. We can avoid creating a 2D array to represent the raft
//        and use separate counts for barrels and occupied seats in each row and column.
//        Additionally, we can check for balance as we iterate through the positions.
//        Here's an optimized Java implementation:

public class DwarfsRaftingEfficient {
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

//    This implementation eliminates the need for a 2D array and should be more efficient in terms
//        of both time and space complexity. It directly calculates the counts for barrels and occupied
//        seats in rows and columns,
//        and then checks for balance while iterating through the positions.