package exercise7DataStructure.hard;

//Count the number of different countries that a map contains.

//A rectangular map consisting of N rows and M columns of square areas is given. Each area is painted with a certain color.
//
//        Two areas on the map belong to the same country if the following conditions are met:
//
//        they have the same color;
//        it is possible to travel from one area to the other orthogonally (that is, by moving only north, south, west or east) without moving over areas of a different color.
//        The map can be described by a zero-indexed matrix A consisting of N rows and M columns of integers. The color of each area is described by the corresponding element of the matrix. Two areas have the same color if and only if their corresponding matrix elements have the same value.
//
//        For example, consider the following matrix A consisting of seven rows and three columns:
//
//        A[0][0] = 5    A[0][1] = 4    A[0][2] = 4
//        A[1][0] = 4    A[1][1] = 3    A[1][2] = 4
//        A[2][0] = 3    A[2][1] = 2    A[2][2] = 4
//        A[3][0] = 2    A[3][1] = 2    A[3][2] = 2
//        A[4][0] = 3    A[4][1] = 3    A[4][2] = 4
//        A[5][0] = 1    A[5][1] = 4    A[5][2] = 4
//        A[6][0] = 4    A[6][1] = 1    A[6][2] = 1
//        Matrix A describes a map that is colored with five colors. The areas on the map belong to eleven different countries (C1−C11), as shown in the following figure:
//
//
//        Write a function
//
//class Solution { public int solution(int[][] A); }
//
//that, given a zero-indexed matrix A consisting of N rows and M columns of integers, returns the number of different countries to which the areas of the map described by matrix A belong.
//
//        For example, given matrix A consisting of seven rows and three columns corresponding to the example above, the function should return 11.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N and M are integers within the range [1..300,000];
//        the number of elements in matrix A is within the range [1..300,000];
//        each element of matrix A is an integer within the range [−1,000,000,000..1,000,000,000].


//To solve this problem, you can use Depth-First Search (DFS) to explore connected areas of the same color. Here's the Java implementation:
public class CountriesCount {
    public int solution(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        boolean[][] visited = new boolean[N][M];
        int countryCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(A, visited, i, j, A[i][j]);
                    countryCount++;
                }
            }
        }

        return countryCount;
    }

    private void dfs(int[][] A, boolean[][] visited, int i, int j, int color) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j] || A[i][j] != color) {
            return;
        }

        visited[i][j] = true;

        // Explore neighbors in all four directions
        dfs(A, visited, i - 1, j, color); // Up
        dfs(A, visited, i + 1, j, color); // Down
        dfs(A, visited, i, j - 1, color); // Left
        dfs(A, visited, i, j + 1, color); // Right
    }
}

//    This solution uses a Depth-First Search (DFS) approach to explore the connected areas of the same color.
//        The dfs function is a recursive helper function that explores the neighboring areas in all four directions (up, down, left, and right).
//
//        The main solution function iterates through each element of the matrix and, if the area is not visited,
//        calls the dfs function to explore and mark all connected areas with the same color.
//        The function increments the countryCount whenever a new connected area is encountered.
//
//        This algorithm has a time complexity of O(N * M), where N is the number of rows and M is the number of columns in the matrix.
