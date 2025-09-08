package lesson6.Easy;

//Certainly! We can solve this problem with O(N) time complexity by avoiding the sorting operation. The key is to recognize that sorting is not necessary for checking the triangular triplet condition.
//
//Here's an updated Java implementation:


public class TriangleEfficientWrongLogicBUTCorrectAnswer {
    public int solution(int[] A) {
        int N = A.length;

        if (N < 3) {
            return 0; // Not enough elements to form a triplet
        }

        for (int i = 0; i < N - 2; i++) {
            if (isTriangular(A[i], A[i + 1], A[i + 2])) {
                return 1; // Triangular triplet found
            }
        }

        return 0; // No triangular triplet found
    }

    private boolean isTriangular(int P, int Q, int R) {
        if (P > R - Q && Q > R - P && R > P - Q) {
            System.out.println("P:"+P+", Q:" +Q+", R:"+R);
        }
        return P > R - Q && Q > R - P && R > P - Q;
    }


    public static void main(String[] args) {
        TriangleEfficientWrongLogicBUTCorrectAnswer solution = new TriangleEfficientWrongLogicBUTCorrectAnswer();
        int [] A = {10, 2, 5, 1, 8, 20};

        System.out.println(solution.solution(A));
    }
}

//In this solution, we directly check the triangular triplet condition without sorting the array.
// The isTriangular helper function checks whether the triplet (P, Q, R) satisfies the triangular inequality conditions.
//
//This solution has a time complexity of O(N) since it iterates through the array once.
// The space complexity is O(1) as it uses a constant amount of extra space regardless of the input size.