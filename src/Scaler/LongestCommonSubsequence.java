package Scaler;


// Find length of common subsequence
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "xyzab";
        String str2 = "abxaaxyzb";
        System.out.println(getCommonSubsequence(str1,str2));
    }

    private static int getCommonSubsequence(String str1, String str2) {
        int[][] LCS = new int[1000][1000];
        for (int i = 0; i<=str1.length(); i++){
            for(int j =0; j<=str2.length(); j++){
                // Base case
                if(i==0 || j==0){
                    LCS[i][j] = 0;
                }
                // Case for next characters are equal
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    LCS[i][j] = 1+LCS[i-1][j-1];
                }
                //Case for next characters unequal
                else if(str1.charAt(i-1) != str2.charAt(j-1)){
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        return LCS[str1.length()][str2.length()];
    }
}
