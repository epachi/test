class Point2D {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PolygonConcavityIndexWRONGSolution {
    public int solution(Point2D[] A) {
        int n = A.length;
        int convexHullSize = 1; // Initialize convex hull size

        // Check if all turns are left turns
        for (int i = 0; i < n; i++) {
            int turn = calculateTurn(A[i], A[(i + 1) % n], A[(i + 2) % n]);
            if (turn < 0) {
                // The polygon is not convex
                return i + 1; // Return the index of the first non-convex point
            }

            // If turn is 0, the points are collinear, and we skip the middle point
            if (turn > 0 || (turn == 0 && isCollinear(A[i], A[(i + 1) % n], A[(i + 2) % n]))) {
                convexHullSize++;
            }
        }

        // If convexHullSize is equal to n, then the polygon is convex
        if (convexHullSize == n) {
            return -1;
        } else {
            // Return the index of the first point that doesn't belong to the convex hull
            return (convexHullSize - 1) % n;
        }
    }

    // Helper method to calculate the cross product of two vectors (AB and BC)
    private int calculateTurn(Point2D A, Point2D B, Point2D C) {
        return (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
    }

    // Helper method to check if three points are collinear
    private boolean isCollinear(Point2D A, Point2D B, Point2D C) {
        return calculateTurn(A, B, C) == 0;
    }

    public static void main(String[] args) {
        PolygonConcavityIndexWRONGSolution solution = new PolygonConcavityIndexWRONGSolution();

        Point2D[] A1 = {
                new Point2D(-1, 3),
                new Point2D(1, 2),
                new Point2D(3, 1),
                new Point2D(0, -1),
                new Point2D(-2, 1)
        };
        System.out.println(solution.solution(A1)); // Output: -1

        Point2D[] A2 = {
                new Point2D(-1, 3),
                new Point2D(1, 2),
                new Point2D(1, 1),
                new Point2D(3, 1),
                new Point2D(0, -1),
                new Point2D(-2, 1),
                new Point2D(-1, 2)
        };
        System.out.println(solution.solution(A2)); // Output: 2 or 6
    }
}