package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackPolishNotation {
    public static void main(String[] args) {
//        String[] arr = new String[]{ "5", "1", "2", "+", "4", "*", "+", "3", "-"};
//        System.out.println(evalRPN(arr));

        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(prevSmaller(arr)));

    }
    public static int evalRPN(String[] A) {
        Stack<String> ans =  new Stack<>();
        for(int i = 0; i <A.length; i++) {
            if(!isOperator(A[i])){
                ans.push(A[i]);
            }else{
                    int num2 = Integer.parseInt(ans.pop());
                    int num1 = Integer.parseInt(ans.pop());
                    switch (A[i]){
                        case "+":
                            ans.push(num1+num2+"");
                            break;
                        case "-":
                            ans.push(num1-num2+"");
                            break;
                        case "*":
                            ans.push(num1*num2+"");
                            break;
                        case "/":
                            ans.push(num1/num2+"");
                            break;
                    }
                }
        }
        return Integer.parseInt(ans.pop());
    }

    // +, -, *, /
    public static boolean isOperator(String c){
        List<String> arr = Arrays.asList("+", "-", "*", "/");
        return arr.contains(c);
    }


    public static int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];

        for(int i =0;i<A.length;i++){
            int currSmall = -1;
            while(!stack.isEmpty()){
                if(stack.peek() < A[i]){
                    currSmall = stack.peek();
                    break;
                }else{
                    stack.pop();
                }
            }
            stack.push(A[i]);
            ans[i] = currSmall;
        }
        return ans;
    }

}
