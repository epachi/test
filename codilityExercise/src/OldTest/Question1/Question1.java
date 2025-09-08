package OldTest.Question1;

public class Question1 {
    public int[] solution(String [] S) {
        for (int i = 0; i < S.length; i++) {
            for (int j= i+1; j < S.length; j++) {
                String str1 = S[i];
                String str2 = S[j];
                for (int k = 0; k < str1.length() ; k++) {
                    if (str1.charAt(k) == str2.charAt(k)) {
                        return new int[]{i, j + i, k};
                    }
                }
            }
        }
        return new int[]{};
    }

    //Print integer array
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static void main(String [] str) {
        Question1.printArray((new Question1()).solution(new String[]{"abc", "bca", "dbe"}));
        Question1.printArray((new Question1()).solution(new String[]{"zzzz", "ferz", "zdsr", "fgtd"}));
        Question1.printArray((new Question1()).solution(new String[]{"gr", "sd", "rg"}));
        Question1.printArray((new Question1()).solution(new String[]{"bdafg", "ceagi"}));

    }

}
