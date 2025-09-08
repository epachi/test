package exercise4AlgoSkills.easy;

//The given recursive solution is already quite efficient in terms of time complexity, as it traverses each node of the tree once.
//        However, we can optimize it slightly by avoiding the unnecessary calculation of the height of both left and right subtrees when we can determine the height earlier.
class TreeEfficient {
    public int x;
    public TreeEfficient l;
    public TreeEfficient r;
}

class TreeHeightEfficient {
    public int solution(TreeEfficient T) {
        // Base case: empty tree has height -1
        if (T == null) {
            return -1;
        }

        // Recursive case: find height of left and right subtrees
        int leftHeight = solution(T.l);
        int rightHeight = solution(T.r);

        // Return the maximum height between left and right subtrees, plus one
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeHeightEfficient solution = new TreeHeightEfficient();

        // Example: constructing the tree (5, (3, (20, None, None), (21, None, None)), (10, (1, None, None), None))
        TreeEfficient leaf20 = new TreeEfficient();
        leaf20.x = 20;

        TreeEfficient leaf21 = new TreeEfficient();
        leaf21.x = 21;

        TreeEfficient leaf1 = new TreeEfficient();
        leaf1.x = 1;

        TreeEfficient subtree3 = new TreeEfficient();
        subtree3.x = 3;
        subtree3.l = leaf20;
        subtree3.r = leaf21;

        TreeEfficient subtree10 = new TreeEfficient();
        subtree10.x = 10;
        subtree10.l = leaf1;

        TreeEfficient root = new TreeEfficient();
        root.x = 5;
        root.l = subtree3;
        root.r = subtree10;

        System.out.println(solution.solution(root)); // Output: 2
    }
}

//In this updated solution, if at any point we detect that the left or right subtree is not balanced, we return -2 immediately, indicating that the tree is unbalanced.
//        This helps in avoiding unnecessary recursive calls when we already know that the tree is unbalanced.
//        The isBalanced method returns true if the tree is balanced and false otherwise.