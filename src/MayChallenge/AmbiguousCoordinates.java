package MayChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AmbiguousCoordinates {

    public static List<String> ambiguousCoordinates(String input) {
        String s = input.substring(1,input.length()-1);
        final List<String> ans = new LinkedList<>();
        for (int i =1; i<s.length(); i++ ){
            List<String> x = getPossiblePoints(s.substring(0,i));
            List<String> y = getPossiblePoints(s.substring(i));
            for (String xlist:x){
                for(String ylist:y){
                    ans.add("(" + xlist + "," + ylist + ")");
                }
            }
        }
        return ans;
    }

    private static List<String> getPossiblePoints(String substring) {
        List<String> result = new ArrayList<>();
        int length = substring.length();
        char[] array = substring.toCharArray();
        if(array[0]=='0' && array[length -1] == '0'){
            if(length == 1)
            {
                result.add("0");
            }
            return result;
        }
        if(array[0]=='0'){
            result.add("0." + substring.substring(1));
            return result;
        }
        if(array[length -1] =='0'){
            result.add(substring);
            return result;
        }
        result.add(substring);
        for (int i = 1;i<length;i++){
            result.add(substring.substring(0,i) + "." + substring.substring(i));
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(Arrays.toString(ambiguousCoordinates("(123)").toArray()));
    }
}
