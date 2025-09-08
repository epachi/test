package lesson14.medium;

//Certainly! We can use a more efficient algorithm based on binary search to find the minimal large sum.
// The key observation is that if we can determine a valid upper bound for the large sum,
// then we can use binary search to find the minimal large sum efficiently.
// Here's the Java implementation:
public class MinMaxDivisionEfficient {
    public int solution(int K, int M, int[] A) {
        int lowerBound = 0;
        int upperBound = 0;

        for (int num : A) {
            upperBound += num;
            lowerBound = Math.max(lowerBound, num);
        }

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;

            if (isValid(mid, K, A)) {
                upperBound = mid - 1;
            } else {
                lowerBound = mid + 1;
            }
        }

        return lowerBound;
    }

    private boolean isValid(int midSum, int K, int[] A) {
        int blocks = 0;
        int currentSum = 0;

        for (int num : A) {
            currentSum += num;
            if (currentSum > midSum) {
                blocks++;
                currentSum = num;
            }
            if (blocks >= K) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinMaxDivisionEfficient solution = new MinMaxDivisionEfficient();
        int K = 3;
        int M = 5;
        int [] A = {2, 1, 5, 1, 2, 2, 2};

        int minMax = solution.solution(K, M, A);

        System.out.println("minMax==>" + minMax);

    }
}


//This algorithm efficiently finds the minimal large sum using binary search, resulting in a time complexity of O(N * log(N + M)).