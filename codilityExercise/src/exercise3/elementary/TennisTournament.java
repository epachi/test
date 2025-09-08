package exercise3.elementary;
//
//You are hosting a tennis tournament. P players, who will take part in the first round of this tournament,
// are already registered and you have reserved C tennis courts for the matches.
// Exactly two players play in each game and only one game can be played on each court at any given time.
// You want to host the maximum possible number of games starting at the same time
// (in order to finish the first round quickly).
//
//        How many games can be hosted in parallel simultaneously?
//
//        Write a function:
//
//class Solution { public int solution(int P, int C); }
//
//that, given the number of players P and the number of reserved courts C,
// returns the maximum number of games that can be played in parallel.
//
//        Examples:
//
//        1. Given P = 5 players and C = 3 available courts, the function should return 2. Two games can be played simultaneously (for instance, the first and second players can play on the first court, and the third and fourth players on the second court, and the third court will be empty because the fifth player does not have a partner to play with).
//
//        2. Given P = 10 players and C = 3 courts, the function should return 3. At most three games can be hosted in parallel.
//
//        Assume that:
//
//        P and C are integers within the range [1..30,000].
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

//To maximize the number of games that can be played in parallel, we need to pair up players and use as many courts as possible.
//        Each game requires two players, so the maximum number of games that can be played in parallel is the minimum of
//        half the number of players and the number of available courts.

public class TennisTournament {
    public int solution(int P, int C) {
        return Math.min(P / 2, C);
    }

    public static void main(String[] args) {
        TennisTournament solution = new TennisTournament();

        // Example 1
        int P1 = 5;
        int C1 = 3;
        System.out.println(solution.solution(P1, C1)); // Output: 2

        // Example 2
        int P2 = 10;
        int C2 = 3;
        System.out.println(solution.solution(P2, C2)); // Output: 3
    }

}

//    This solution calculates the maximum number of games by dividing the number of players by 2 and taking the minimum of that result and the number of available courts.
//        It reflects the fact that each game requires two players, and we want to use as many courts as possible.