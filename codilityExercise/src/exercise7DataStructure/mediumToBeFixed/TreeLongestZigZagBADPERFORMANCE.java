package exercise7DataStructure.mediumToBeFixed;

//In this problem we consider binary trees. Let's define a turn on a path as a change in the direction of the path (i.e. a switch from right to left or vice versa). A zigzag is simply a sequence of turns (it can start with either right or left). The length of a zigzag is equal to the number of turns.
//
//        Consider binary tree below:
//
//        (5, (3, (20, (6, None, None), None), None), (10, (1, None, None), (15, (30, None, (9, None, None)), (8, None, None))))
//
//        There are two turns on the path: 5 -> 10 -> 15 -> 30 -> 9. The first one is at [15]; the second is at [30]. That means that the length of this zigzag is equal to 2. This is also the longest zigzag in the tree under consideration. In this problem you should find the longest zigzag that starts at the root of any given binary tree and form a downwards path.
//
//        Note that a zigzag containing only one edge or one node has length 0.
//
//        Problem
//        Write a function:
//
//class Solution { public int solution(Tree T); }
//
//that, given a non-empty binary tree T consisting of N nodes, returns the length of the longest zigzag starting at the root.
//
//        For example, given tree T shown in the figure above, the function should return 2, as explained above. Note that the values contained in the nodes are not relevant in this task.
//
//        Technical details
//        A binary tree can be specified using a pointer data structure. Assume that the following declarations are given:
//
//class Tree {
//    public int x;
//    public Tree l;
//    public Tree r;
//}
//
//    An empty tree is represented by an empty pointer (denoted by null). A non-empty tree is represented by a pointer to an object representing its root. The attribute x holds the integer contained in the root, whereas attributes l and r hold the left and right subtrees of the binary tree, respectively.
//
//        For the purpose of entering your own test cases, you can denote a tree recursively in the following way. An empty binary tree is denoted by None. A non-empty tree is denoted as (X, L, R), where X is the value contained in the root and L and R denote the left and right subtrees, respectively. The tree from the above figure can be denoted as:
//
//        (5, (3, (20, (6, None, None), None), None), (10, (1, None, None), (15, (30, None, (9, None, None)), (8, None, None))))
//        Assumptions
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        the height of tree T (number of edges on the longest path from root to leaf) is within the range [0..800].


class Tree {
    public int x;
    public Tree l;
    public Tree r;
}
public class TreeLongestZigZagBADPERFORMANCE {
    public int solution(Tree T) {
        if (T == null) {
            return 0;
        }

        // Calculate the length of zigzag for left and right subtrees
//        int leftZigzag = calculateZigzag(T.l, 1, true);
//        int rightZigzag = calculateZigzag(T.r, 1, false);
        int leftZigzag = calculateZigzag(T.l, 0, true);
        int rightZigzag = calculateZigzag(T.r, 0, false);

        // Return the maximum of left and right zigzag lengths
        return Math.max(leftZigzag, rightZigzag);
    }

    // Helper function to calculate zigzag length recursively
    private int calculateZigzag(Tree node, int length, boolean isLeft) {
        if (node == null) {
            return Math.max(0, length - 1); // Exclude the root node itself
        }

        // Recursively calculate zigzag for left and right subtrees
//        int leftZigzag = calculateZigzag(node.l, (isLeft ? 1 : length + 1), true);
//        int rightZigzag = calculateZigzag(node.r, (isLeft ? length + 1 : 1), false);
        int leftZigzag = calculateZigzag(node.l, (isLeft ? length : length + 1), true);
        int rightZigzag = calculateZigzag(node.r, (isLeft ? length + 1 : length), false);

        // Return the maximum of left and right zigzag lengths
        return Math.max(leftZigzag, rightZigzag);
    }

    private static Tree createTree() {



//        Tree sixTree = new Tree();
//        sixTree.x=6;
//
//        Tree twentyTree = new Tree();
//        twentyTree.x = 20;
//        twentyTree.l = sixTree;
//
//        Tree threeTree = new Tree();
//        threeTree.x = 3;
//        threeTree.l = twentyTree;
//
//        Tree fiveTree = new Tree();
//        fiveTree.x = 5;
//        fiveTree.l=threeTree;
//
//        Tree oneTree = new Tree();
//        oneTree.x = 1;
//
//        Tree tenTree = new Tree();
//        tenTree.x = 10;
//        tenTree.l=oneTree;
//
////        Tree twoHundredTree = new Tree();
////        twoHundredTree.x = 200;
////        oneTree.r = twoHundredTree;
//
//        fiveTree.r=tenTree;
//
//        Tree eightTree = new Tree();
//        eightTree.x = 8;
//
//        Tree fifthTeenTree = new Tree();
//        fifthTeenTree.x = 15;
//        fifthTeenTree.r=eightTree;
//
//        tenTree.r=fifthTeenTree;
//
//        Tree nineTree = new Tree();
//        nineTree.x = 9;
//
//        Tree thirtyTree = new Tree();
//        thirtyTree.x = 30;
//        thirtyTree.r=nineTree;
//
//        fifthTeenTree.l=thirtyTree;
//
//
////        Tree hundredTree = new Tree();
////        hundredTree.x = 100;
////        nineTree.l = hundredTree;


        Tree fiveTree = new Tree();
        fiveTree.x = 5;
        Tree threeTree = new Tree();
        threeTree.x = 3;
        fiveTree.l=threeTree;
        Tree tenTree = new Tree();
        tenTree.x = 10;
        fiveTree.r=tenTree;
        Tree twentyTree = new Tree();
        twentyTree.x = 20;
        threeTree.l=twentyTree;
        Tree sixTree = new Tree();
        sixTree.x = 6;
        twentyTree.l=sixTree;

        Tree fifthTeenTree = new Tree();
        fifthTeenTree.x = 15;
        tenTree.r=fifthTeenTree;

        Tree oneTree = new Tree();
        oneTree.x = 1;
        tenTree.l=fifthTeenTree;

        Tree thirtyTree = new Tree();
        thirtyTree.x = 30;
        fifthTeenTree.l=thirtyTree;

        Tree nineTree = new Tree();
        nineTree.x = 9;
        thirtyTree.r=nineTree;

        Tree eightTree = new Tree();
        eightTree.x = 8;
        fifthTeenTree.r=eightTree;

        return fiveTree;
    }

    public static void main(String[] args) {
        TreeLongestZigZagBADPERFORMANCE solution = new TreeLongestZigZagBADPERFORMANCE();
        Tree tree = createTree();
        System.out.println(solution.solution(tree)); // Output: 2

    }
}

//In this implementation, the dfs function is a recursive function that performs the depth-first search traversal.
// It takes the current node, the length of the zigzag path, and a boolean flag indicating the direction of the traversal
// (whether it's coming from the left or right child).
//
//        The base case checks if the current node is null, and if so, returns the length of the zigzag path minus
//        1. Otherwise, it calculates the lengths of the zigzag paths for both left and right children and recursively calls the dfs function.
//
//        The solution function initializes the traversal by calling dfs on both left and right children of the root and returns the maximum length
//        of the zigzag path.
//
//        This algorithm has a time complexity of O(N), where N is the number of nodes in the binary tree.