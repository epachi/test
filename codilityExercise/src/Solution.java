import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {

    public int solution(String E, String L) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        try {
            Date entryTime = format.parse(E);
            Date exitTime = format.parse(L);

            long durationInMilliseconds = exitTime.getTime() - entryTime.getTime();
            long durationInMinutes = durationInMilliseconds / (60 * 1000);

            int cost = 2; // Entrance fee

            if (durationInMinutes <= 60) {
                cost += 3; // First hour or part of it
            } else {
                cost += 3; // First hour or part of it
                durationInMinutes -= 60;

                // Calculate the cost for each successive hour or part of it
                cost += (durationInMinutes / 60) * 4;
                if (durationInMinutes % 60 > 0) {
                    cost += 4;
                }
            }

            return cost;
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
            return -1; // Error indicator
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.solution("10:00", "13:21")); // Should return 17
        System.out.println(solution.solution("09:42", "11:42")); // Should return 9
    }
}