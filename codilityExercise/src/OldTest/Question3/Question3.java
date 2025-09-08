package OldTest.Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question3 {
    public int solution(int[]A) {
        int originalTotalTreeCounts = 0;
        List<Integer> treeCountList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            originalTotalTreeCounts+=A[i];
            treeCountList.add(A[i]);
        }

        Collections.sort(treeCountList);

        int idealNumberOfTreesPerGarden =
                (originalTotalTreeCounts / treeCountList.size() + (originalTotalTreeCounts % treeCountList.size() !=0? 1:0));
        int treesToBePlanted = idealNumberOfTreesPerGarden*treeCountList.size() - originalTotalTreeCounts;
        System.out.println("treesToBePlanted " + treesToBePlanted);

        int startIndex = 0;
        int endIndex = treeCountList.size() - 1;

        int numOfOperations = 0;
        while (startIndex < endIndex) {
            int numOfTreeAtStartIndex = treeCountList.get(startIndex);
            int numOfTreeAtEndIndex = treeCountList.get(endIndex);
            if (numOfTreeAtStartIndex < idealNumberOfTreesPerGarden && numOfTreeAtEndIndex> idealNumberOfTreesPerGarden) {
                treeCountList.set(startIndex, numOfTreeAtStartIndex + 1);
                treeCountList.set(endIndex, numOfTreeAtEndIndex - 1);
                numOfOperations++;
            } else if ((numOfTreeAtStartIndex == idealNumberOfTreesPerGarden) ||(numOfTreeAtEndIndex == idealNumberOfTreesPerGarden)){
                if (numOfTreeAtStartIndex == idealNumberOfTreesPerGarden){
                    startIndex++;
                }
                if (numOfTreeAtEndIndex == idealNumberOfTreesPerGarden) {
                    endIndex--;
                }
            } else if ((numOfTreeAtStartIndex < idealNumberOfTreesPerGarden) || (numOfTreeAtEndIndex < idealNumberOfTreesPerGarden)){
//                if (numOfTreeAtStartIndex < idealNumberOfTreesPerGarden) {
//                    // grow N trees
//                    numOfOperations = numOfOperations + (idealNumberOfTreesPerGarden - numOfTreeAtStartIndex);
//                    treeCountList.set(startIndex, idealNumberOfTreesPerGarden);
//                    startIndex++;
//                }
//                if (numOfTreeAtEndIndex < idealNumberOfTreesPerGarden) {
//                    // grow N trees
//                    numOfOperations = numOfOperations + (idealNumberOfTreesPerGarden - numOfTreeAtEndIndex);
//                    treeCountList.set(endIndex, idealNumberOfTreesPerGarden);
//                    endIndex--;
//                }
                numOfOperations = numOfOperations + treesToBePlanted;
            }
        }

        return numOfOperations;
    }


    public static void main(String [] str) {
        System.out.println("$$$" + (new Question3()).solution(new int[]{1, 2, 2, 4}));          //4
        System.out.println("$$$" + (new Question3()).solution(new int[]{4, 2, 4, 6}));          //2
        System.out.println("$$$" + (new Question3()).solution(new int[]{1, 1, 2, 1}));          //3
    }

}
