package exercise5CodingSkills.elementary;
//
//The provided solution is already relatively straightforward and efficient.
//        The time complexity is dominated by the parsing of time strings and the calculation of the total cost,
//        both of which are linear with respect to the input size.
//
//        However, if you want to make the code more concise or use a more modern date/time API,
//        you can leverage the LocalTime class from the java.time package, introduced in Java 8. Here's an updated version using LocalTime:


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

class ParkingBillEfficient {
    public int solution(String E, String L) {
        int entranceFee = 2;
        int firstHourCost = 3;
        int successiveHourCost = 4;

        LocalTime entryTime = LocalTime.parse(E);
        LocalTime exitTime = LocalTime.parse(L);

        long durationInMinutes = ChronoUnit.MINUTES.between(entryTime, exitTime);

        int totalCost = entranceFee + firstHourCost;
        durationInMinutes -= 60;  // Deduct the first hour

        while (durationInMinutes > 0) {
            totalCost += successiveHourCost;
            durationInMinutes -= 60;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        ParkingBillEfficient solution = new ParkingBillEfficient();
        System.out.println(solution.solution("10:00", "13:21")); // Output: 17
        System.out.println(solution.solution("09:42", "11:42")); // Output: 9
    }
}
//    This version uses LocalTime.parse() for parsing time strings and ChronoUnit.MINUTES.between() for calculating the duration.
//        It may be considered more modern and concise, but the efficiency remains similar.