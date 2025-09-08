package OldTest.Question2;

public class Question2 {
    public int solution(int []D, int X) {
        int numberOfDays = 0;

        int dateStartIndex = 0;
        boolean dailyStop = false;

        //Daily Start
        while (dailyStop == false && dateStartIndex < D.length) {
            int i = dateStartIndex;
            int dailyMinLevel = D[i];
            int dailyMaxLevel = D[i];
            numberOfDays++;
            dateStartIndex++;
            for (int j = i + 1; j < D.length; j++) {
                dailyStop = (D[j] - dailyMinLevel > X || dailyMaxLevel - D[j] > X);
                if (dailyStop) {
                    dailyStop = false;
                    break;
                }
                dailyMaxLevel = Math.max(dailyMaxLevel, D[j]);
                dailyMinLevel = Math.min(dailyMinLevel, D[j]);
                dateStartIndex++;
            }
        }
        return numberOfDays;



    }

    public static void main(String [] str) {
        System.out.println("$$$" + (new Question2()).solution(new int[]{5, 8, 2, 7}, 3));               //3
        System.out.println("$$$" + (new Question2()).solution(new int[]{2, 5, 9, 2, 1, 4}, 4));         //3
        System.out.println("$$$" + (new Question2()).solution(new int[]{1, 12, 10, 4, 5, 2}, 2));       //4
    }

}
