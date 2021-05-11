package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
class ValidParanthesis {
    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');
        for(int i=0; i< s.length(); i++){
            if(brackets.containsValue(s.charAt(i))){
                charStack.push(s.charAt(i));
            }else {
                if(charStack.empty()){
                    return false;
                }else {
                    if(brackets.get(s.charAt(i)) == charStack.peek())
                        charStack.pop();
                    else
                        return false;
                }
            }
        }
        return charStack.empty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> charStack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (brackets.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = charStack.empty() ? '#' : charStack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != brackets.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                charStack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return charStack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("()({]})"));
    }
}