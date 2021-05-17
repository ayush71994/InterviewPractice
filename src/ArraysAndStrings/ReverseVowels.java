package ArraysAndStrings;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class ReverseVowels {
    private static List<Character> TO_BE_REVERSED = Arrays.asList('a','e','i','o','u','A','E','I','O','U') ;
    public static String reverseVowels(String s) {
        int startIndex = 0;
        int lastIndex = s.length() - 1;
        char[]  charArray = s.toCharArray();
        while(startIndex < lastIndex){
            if(isVowel(charArray[startIndex]) && isVowel(charArray[lastIndex])){
                swapCharacters(startIndex, lastIndex, charArray);
                startIndex ++;
                lastIndex --;
            }
            else if(!isVowel(charArray[startIndex])){
                startIndex++;
            }
            else if(!isVowel(charArray[lastIndex])){
                lastIndex--;
            }
        }
        return String.valueOf(charArray);
    }

    private static void swapCharacters(int startIndex, int lastIndex, char[] chars) {
        char temp = chars[startIndex];
        chars[startIndex] = chars[lastIndex];
        chars[lastIndex] = temp;
    }

    public static boolean isVowel(char c){
        return TO_BE_REVERSED.contains(c);
     }

    public static void main(String[] args){
        System.out.println(reverseVowels("hello"));
    }
}
