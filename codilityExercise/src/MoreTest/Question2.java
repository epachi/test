package MoreTest;

import java.util.*;

//There are N players standing in a row, one player on a field. They are numbered from 0 to N-1 from left to right.
//Players perform moves one by one from left to right, that is, in ascending order of numbers.
//Each player presses an arrow key in one of the four cardinal directions: left ('<'), right (>), up (^) or down (v).
//A key press in the given direction means that the player attempts to move onto the closest field in the direction specified.
//A move can be performed only if there is no other player already standing on the target field.
//
//
//Moves are represented as a string S of length N, where S[K] (for K within the range 0..N-1) is the direction of the K-th player's move.
//How many players will actually perform a move successfully?
//Write a function:
//class Solution { public int solution (String S); }
//which, given a string S of length N representing arrow keys pressed by each of the players,
//returns the number of players that will perform a move successfully.
//
//        Examples:
//        1. Given S = "><^v", your function should return 2. Player 0 cannot move rightwards, because player 1 is standing on the target field.
//Player 1 cannot move leftwards, because player 0 is standing on the target field. Players 2 and 3 can both perform their moves
//because there are no other players standing on their target fields. In the pictures below, players that will perform their
//moves successfully are marked green and players whose moves will fail are marked red.
//
//
//
//        2. Given S = "<<^<v>>", your function should return 6. Players 0, 1, 2, 3, 4 can all perform their moves because
//there are no other players standing on their target fields. Player 5 pressed the right-arrow key,
//but the move cannot be performed as player 6 is already standing on the target field.
//The move of player 6 can be performed, though, as there is no other player standing on the target field.
//
//3. Given S = "><><", your function should return 0. No player can perform a move
//
//Assume that:
//        - N is an integer within the range [1..50];
//        - string S is made only of the following characters: vand/or
//In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

public class Question2 {    public int solution(String S) {
    int N = S.length();
    // Track which positions in the row are occupied
    Set<Integer> occupied = new HashSet<>();

    // Initially all players are at positions 0, 1, 2, ..., N-1
    for (int i = 0; i < N; i++) {
        occupied.add(i);
    }

    int successfulMoves = 0;

    // Process each player in order from left to right
    for (int player = 0; player < N; player++) {
        char direction = S.charAt(player);
        int currentPos = player;
        int targetPos;

        // Determine target position based on direction
        switch (direction) {
            case '<':
                targetPos = currentPos - 1;
                break;
            case '>':
                targetPos = currentPos + 1;
                break;
            case '^':
            case 'v':
                // Moving up or down - these positions are outside the row
                // so they're always available
                successfulMoves++;
                occupied.remove(currentPos);
                continue;
            default:
                continue; // Invalid direction
        }

        // Check if target position is available (not occupied by another player)
        if (!occupied.contains(targetPos)) {
            // Move is successful
            successfulMoves++;
            occupied.remove(currentPos);
            occupied.add(targetPos);
        }
        // If target position is occupied, player stays in place
    }

    return successfulMoves;
}

    // Test method to verify the solution
    public static void main(String[] args) {
        Question2 sol = new Question2();

        // Test case 1: "><^v" should return 2
        System.out.println("Test 1: " + sol.solution("><^v")); // Expected: 2

        // Test case 2: "<<^<v>>" should return 6
        System.out.println("Test 2: " + sol.solution("<<^<v>>")); // Expected: 6

        // Test case 3: "><><" should return 0
        System.out.println("Test 3: " + sol.solution("><><")); // Expected: 0

        // Additional test cases
        System.out.println("Test 4: " + sol.solution(">>>")); // Expected: 1 (only first player moves)
        System.out.println("Test 5: " + sol.solution("<<<")); // Expected: 3 (only last player moves)
        System.out.println("Test 6: " + sol.solution("^^^")); // Expected: 3 (all can move up)
    }
}
