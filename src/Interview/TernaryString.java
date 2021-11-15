package Interview;

public class TernaryString {

    public static void main(String[] args) {
        int N = 3;
        int atmostB = 1;
        int atmostC = 4;

        System.out.println(numberOfStrings(4, atmostB, atmostC));
        System.out.println(numberOfStrings2(4, atmostB, 2));
    }

    private static int numberOfStrings2(int N, int atmostB, int aConsecuttiveAllowed){
        int[][][] dp = new int[N+1][atmostB +1][aConsecuttiveAllowed +1];
        for(int i = 0; i<=N; i++){
            for(int j = 0; j<=atmostB; j++){
                for(int k = 0;k<=aConsecuttiveAllowed; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return numberOfStrings2Recur(dp, N, atmostB,aConsecuttiveAllowed);
    }


    private static int numberOfStrings(int N, int atmostB, int atmostC){
        int[][][] dp = new int[N+1][atmostB +1][atmostC +1];
        for(int i = 0; i<=N; i++){
            for(int j = 0; j<=atmostB; j++){
                for(int k = 0;k<=atmostC; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return numberOfStringsRecur(dp, N, atmostB,atmostC);
    }

    // Function for
    // Number of Strings of length N that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
    private static int numberOfStringsRecur(int[][][] dp, int N, int bCount, int cCount) {
        if(bCount < 0 || cCount < 0){
            return 0;
        }
        if(N==0) {
            return 1;
        }
        if(bCount ==0 && cCount ==0) {
            return 1;
        }
        if(dp[N][bCount][cCount] != -1){
            return dp[N][bCount][cCount] ;
        }
        int result  =
            // using a
            numberOfStringsRecur(dp,N-1, bCount, cCount) +
            // using b
            numberOfStringsRecur(dp,N-1, bCount - 1, cCount) +
            // using c
            numberOfStringsRecur(dp,N-1, bCount,cCount -1);
        dp[N][bCount][cCount] = result;
        return  result;
    }

    // Function for
    // Number of Strings of length N that can be made using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and no two consecutive a's.
    private static int numberOfStrings2Recur( int[][][]dp, int N, int bCount, int aConsecutiveCount) {
        if(bCount < 0 || aConsecutiveCount < 0){
            return 0;
        }
        if(N==0) {
            return 1;
        }
        if(dp[N][bCount][aConsecutiveCount] != -1){
            return dp[N][bCount][aConsecutiveCount] ;
        }
        int result  =
            // using a
            numberOfStrings2Recur(dp,N-1, bCount, aConsecutiveCount-1) +
            // using b
            numberOfStrings2Recur(dp,N-1, bCount - 1, 2) +
            // using c
            numberOfStrings2Recur(dp,N-1, bCount,2);
        dp[N][bCount][aConsecutiveCount] = result;
        return  result;
    }

}
