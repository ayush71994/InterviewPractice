package InterviewBit;

public class Sixlets {
    public static int solve(int[] A, int B) {
        return subSequenceCount(A, B, 0, 0, 0, 0);
    }

    public static int subSequenceCount(int[] A,int maxLen, int currLen, int currSum, int currCount, int currIndex){
        if(currSum > 1000) return 0;
        if( currLen == maxLen){
            return 1;
        }
        if(currIndex>=A.length) return 0;
        int count = subSequenceCount(A, maxLen, currLen, currSum, currCount, currIndex + 1)
            + subSequenceCount(A, maxLen, currLen + 1, currSum + A[currIndex], currCount, currIndex + 1);
        return count;

    }

    // Function to count the number of inversions
    // during the merge process


    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,82,970}, 2));
    }

}
