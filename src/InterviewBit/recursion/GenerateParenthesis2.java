package InterviewBit.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis2 {
    List<String> result = new ArrayList<>();
    public String[] generateParenthesis(int A) {
        generateParenthesis(A,"(", A-1, A,1);
        String[] resultArray = new String[result.size()];
        for(int i =0;i <resultArray.length;i++)
            resultArray[i] = result.get(i);
        return resultArray;
    }

    private void generateParenthesis(int A, String currString,int remainingOpen, int remainingClosed, int currentOpen) {
        if(currString.length() == A*2){
            result.add(currString);
            return;
        }
        if(remainingOpen > 0){
            generateParenthesis(A,currString + "(", remainingOpen-1,remainingClosed,currentOpen +1);
        }
        if(remainingClosed > 0 && currentOpen >0 ){
            generateParenthesis(A,currString + ")", remainingOpen,remainingClosed-1, currentOpen -1);
        }

    }

}
