package exercise5CodingSkills.elementary;

//You parked your car in a parking lot and want to compute the total cost of the ticket. The billing rules are as follows:
//
//        The entrance fee of the car parking lot is 2;
//        The first full or partial hour costs 3;
//        Each successive full or partial hour (after the first) costs 4.
//        You entered the car parking lot at time E and left at time L. In this task, times are represented as strings in the format "HH:MM" (where "HH" is a two-digit number between 0 and 23, which stands for hours, and "MM" is a two-digit number between 0 and 59, which stands for minutes).
//
//        Write a function:
//
//class Solution { public int solution(String E, String L); }
//
//that, given strings E and L specifying points in time in the format "HH:MM", returns the total cost of the parking bill from your entry at time E to your exit at time L. You can assume that E describes a time before L on the same day.
//
//        For example, given "10:00" and "13:21" your function should return 17, because the entrance fee equals 2, the first hour costs 3 and there are two more full hours and part of a further hour, so the total cost is 2 + 3 + (3 * 4) = 17. Given "09:42" and "11:42" your function should return 9, because the entrance fee equals 2, the first hour costs 3 and the second hour costs 4, so the total cost is 2 + 3 + 4 = 9.
//
//        Assume that:
//
//        strings E and L follow the format "HH:MM" strictly;
//        string E describes a time before L on the same day.
//        In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class ParkingBillRevisited {
    public int solution(String E, String L) {
        // Define constants
        int entranceFee = 2;
        int firstHourCost = 3;
        int successiveHourCost = 4;

        // Parse the time strings into Date objects
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");                         //<==== SimpleDateFormat
        try {
            Date entryTime = dateFormat.parse(E);
            Date exitTime = dateFormat.parse(L);

            // Calculate the duration in minutes
            long durationInMinutes = (exitTime.getTime() - entryTime.getTime()) / (60 * 1000);      //<==== Date.getTime()

            // Calculate the total cost based on the billing rules
            int totalCost = entranceFee + firstHourCost;
            durationInMinutes -= 60;  // Deduct the first hour

            // Calculate additional full or partial hours
            while (durationInMinutes > 0) {
                totalCost += successiveHourCost;
                durationInMinutes -= 60;
            }

            return totalCost;
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
            return -1; // or throw an exception
        }
    }

    public static void main(String[] args) {
        ParkingBillRevisited solution = new ParkingBillRevisited();
        System.out.println(solution.solution("10:00", "13:21")); // Output: 17
        System.out.println(solution.solution("09:42", "11:42")); // Output: 9
    }
}
//
//    This implementation uses the SimpleDateFormat class to parse the time strings and calculates the total cost based on the given rules.
//        Note that the entrance fee and costs for the first and successive hours are defined as constants for clarity.