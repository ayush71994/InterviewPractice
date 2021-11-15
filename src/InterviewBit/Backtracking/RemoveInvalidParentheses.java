package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveInvalidParentheses {
    static ArrayList<String> result;

    public static ArrayList<String> solve(String A) {
        int numClosed = 0;
        int numOpen =0;
        result = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '('){
                numOpen++;
            }else if (A.charAt(i) == ')'){
                numClosed++;
            }
        }
        removeInvalidParanthesis(A,0,numOpen, numClosed, "");
        return result;
    }

    private static void removeInvalidParanthesis(String a,int start, int numOpen, int numClosed, String current) {
        if(start == a.length()){
            if(numOpen == numClosed && validParanthesis(current) && !result.contains(current) && current!="") {
                result.add(current);
            }
            return;
        }
        if(a.charAt(start) == '('){
            removeInvalidParanthesis(a, start +1, numOpen -1, numClosed, current);
            current = current + '(';
            removeInvalidParanthesis(a, start +1, numOpen, numClosed, current );
        }else if(a.charAt(start) == ')'){
            removeInvalidParanthesis(a, start +1, numOpen , numClosed - 1, current);
            current = current + ')';
            removeInvalidParanthesis(a, start +1, numOpen, numClosed, current );
        }else {
            current = current + a.charAt(start);
            removeInvalidParanthesis(a, start + 1, numOpen, numClosed, current);
        }
    }

    private static boolean validParanthesis(String current) {
        Stack<Character> open = new Stack<>();
        for(int i =0; i<current.length(); i++){
            if(current.charAt(i) == '(')
                open.add('(');
            else if(current.charAt(i) == ')'){
                if(open.isEmpty())
                    return false;
                open.pop();
            }
        }
        return open.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solve("()))()"));
    }

}
