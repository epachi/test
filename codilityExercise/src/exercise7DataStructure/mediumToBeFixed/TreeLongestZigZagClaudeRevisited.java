package exercise7DataStructure.mediumToBeFixed;


class Tree1 {
    public int x;
    public Tree l;
    public Tree r;

    public Tree1(int x) {
        this.x = x;
        this.l = null;
        this.r = null;
    }

    public Tree1(int x, Tree l, Tree r) {
        this.x = x;
        this.l = l;
        this.r = r;
    }
}

class TreeLongestZigZagClaude {
    public int solution(Tree T) {
        if (T == null) {
            return 0;
        }

        // Start exploring from root in both directions
        int maxZigzag = 0;

        // Try going left first
        if (T.l != null) {
            maxZigzag = Math.max(maxZigzag, dfs(T.l, 'L', 0));
        }

        // Try going right first
        if (T.r != null) {
            maxZigzag = Math.max(maxZigzag, dfs(T.r, 'R', 0));
        }

        return maxZigzag;
    }

    private int dfs(Tree node, char prevDirection, int turns) {
        if (node == null) {
            return turns;
        }

        int maxTurns = turns;

        // Try going left
        if (node.l != null) {
            int newTurns = turns;
            if (prevDirection == 'R') {
                newTurns++; // We're turning from right to left
            }
            maxTurns = Math.max(maxTurns, dfs(node.l, 'L', newTurns));
        }

        // Try going right
        if (node.r != null) {
            int newTurns = turns;
            if (prevDirection == 'L') {
                newTurns++; // We're turning from left to right
            }
            maxTurns = Math.max(maxTurns, dfs(node.r, 'R', newTurns));
        }

        return maxTurns;
    }
}