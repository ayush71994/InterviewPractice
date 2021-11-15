package Scaler;

public class RegexExpressionMatch {

    public static void main(String[] args) {
        String regex ="a";
        String input = "aa";
        System.out.println(regexMatches(regex, input));
    }

    private static boolean regexMatches(String regex, String input) {
        boolean regexDp[][] = new boolean[1000][1000];

        for (int i=0; i<=regex.length(); i++){
            for(int j=0; j<=input.length(); j++){
                if(i==0 && j==0){
                    regexDp[i][j] = true;
                }
                else if (i==0){
                    regexDp[i][j] = false;
                }
                else if (j==0){
                    if(regex.charAt(i-1) == '*'){
                        regexDp[i][j] = regexDp[i-1][j];
                    }else {
                        regexDp[i][j] = false;
                    }
                }
                else if(regex.charAt(i-1) == input.charAt(j-1)){
                    regexDp[i][j] = regexDp[i-1][j-1];
                }
                else if(regex.charAt(i-1) == '?'){
                    regexDp[i][j] = regexDp[i-1][j-1];
                }
                else if(regex.charAt(i-1) == '*'){
                        regexDp[i][j] = regexDp[i - 1][j] || regexDp[i][j - 1];
                }
                else {
                    regexDp[i][j] = false;
                }
            }
        }
        return regexDp[regex.length()][input.length()];
    }

}
