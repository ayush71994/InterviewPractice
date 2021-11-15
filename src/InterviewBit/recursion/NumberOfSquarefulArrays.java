package InterviewBit.recursion;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSquarefulArrays {
    static int count = 0;

    public static int solve(int[] A) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for (int i = 0; i <A.length; i++) {
            frequency.put(A[i], frequency.getOrDefault(A[i],0)+1);
        }
        countSquarefullPerm(A, new int[A.length], 0, frequency);
        return count;
    }

    public static void countSquarefullPerm(int[] A, int[] curr, int index, Map<Integer,Integer> frequency) {
        if (index == A.length) {
            count++;
        }
        for (Map.Entry<Integer,Integer> entry : frequency.entrySet()){
            int currentFreq = entry.getValue();
            if (currentFreq > 0) {
                if (index == 0 || isPerfectSquare(curr[index - 1] + entry.getKey())) {
                    curr[index] = entry.getKey();
                    frequency.put(entry.getKey(), currentFreq-1);
                    countSquarefullPerm(A, curr, index +1,frequency);
                    frequency.put(entry.getKey(), currentFreq);
                }
            }

        }
    }

    private static boolean isPerfectSquare(int num){
        double root = Math.sqrt(num);
        return !((root - ((int) root)) > 0);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,17,8,}));
    }
}
