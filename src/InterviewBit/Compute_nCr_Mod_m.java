package InterviewBit;

import java.util.HashMap;
import java.util.Map;

public class Compute_nCr_Mod_m {

    public static int solve(int A, int B, int C) {
        int[][] pascal = new int[A+1][B+1];
        for (int i = 0; i<=A ; i++){
            pascal[i][0] = 1;
            pascal[i][1] = i;
            if(i<B) pascal[i][i] = 1;
        }
        for(int i =2; i <=A ; i++){
            for(int j =1 ; j<=B && j<=i;j++){
                pascal[i][j] = (pascal[i-1][j] + pascal[i-1][j-1]) % C;
            }
        }
        return pascal[A][B];
    }


    public static  int solve2(int A, int B, int C) {
        long ans =1;
        int countA = A;
        while(countA> (A-B)){
            ans=(ans * countA) %C;
            countA--;
        }

        int countB = B;
        Long bFact = 1L;
        while (countB>1){
            bFact=bFact * countB ;
            countB--;
        }

        Map<Long, Long> memoization = new HashMap<Long,Long>();
        memoization.put(0L, (long)1);
        memoization.put(1L, (long)(bFact));
        ans = (ans * power(bFact, C-2, C, memoization) )% C;
        return (int)ans;
    }

    public static long power(long base, long power, long mod, Map<Long, Long> memoization) {
        if (memoization.get(power) != null) {
            return memoization.get(power);
        }
        long result;
        if (power % 2 == 0) {
            result = power(base, power / 2, mod, memoization) * power(base, power / 2, mod, memoization);
        } else {
            result = (base * ((power(base, (power - 1) / 2, mod, memoization) * power(base, (power - 1) / 2, mod, memoization))% mod));
        }
        result = result % mod;
        memoization.put(power, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve2(5,2,13));
    }

}
