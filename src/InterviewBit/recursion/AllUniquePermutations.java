package InterviewBit.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllUniquePermutations {
    static List<List<Integer>> result = new ArrayList<>();

    public static int[][] permute(int[] A) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for (int i = 0; i <A.length; i++) {
            frequency.put(A[i], frequency.getOrDefault(A[i],0)+1);
        }
        countUniquePerm(A, new ArrayList<Integer>(), 0, frequency);

        int[][] resultArray = new int[result.size()][A.length];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < A.length; j++) {
                resultArray[i][j] = result.get(i).get(j);
            }
        }
        return resultArray;
    }

    public static  void countUniquePerm(int[] A, List<Integer> curr, int index, Map<Integer,Integer> frequency) {
        if (index == A.length) {
            result.add(new ArrayList<>(curr));
        }
        for (Map.Entry<Integer,Integer> entry : frequency.entrySet()){
            int currentFreq = entry.getValue();
            if (currentFreq > 0) {
                curr.add(entry.getKey());
                frequency.put(entry.getKey(), currentFreq-1);

                countUniquePerm(A, curr, index +1, frequency);
                // undo
                curr.remove(index);
                frequency.put(entry.getKey(), currentFreq);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

}
