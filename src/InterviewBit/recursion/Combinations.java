package InterviewBit.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static List<List<Integer>> result = new ArrayList<>();

    public int[][] combine(int A, int B) {
        uniqueCombinations(A,B,new ArrayList<Integer>(),1,0);

        int[][] resultArray = new int[result.size()][B];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < B; j++) {
                resultArray[i][j] = result.get(i).get(j);
            }
        }
        return resultArray;
    }

    public static void uniqueCombinations(int A, int B, List<Integer> curr,int start, int index) {
        if (index == B) {
            result.add(new ArrayList<>(curr));
        }
        for (int i =start; i <=A; i++) {
            curr.add(i);
            uniqueCombinations(A,B, curr,i+1,index+1);
            curr.remove(index);
        }
    }
}
