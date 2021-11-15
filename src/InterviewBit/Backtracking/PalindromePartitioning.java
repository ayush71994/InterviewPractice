package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static ArrayList<ArrayList<String>> partitioning;
    public  static ArrayList<ArrayList<String>> partition(String a) {
        partitioning = new ArrayList<>();
        palindromePartition(a,0,0,new ArrayList<String>(), 0);
        return partitioning;
    }

    public static void palindromePartition(String a, int start, int end, List<String> current, int currentInd){
        if(end==a.length()){
            partitioning.add(new ArrayList<>(current));
            return;
        }
        for(int i = end; i<a.length(); i++){
            String sub = a.substring(start,i+1);
            if(isPalindrome(sub)){
                current.add(sub);
                palindromePartition(a, i+1,i+1, current,currentInd +1);
                current.remove(currentInd);
            }
        }

    }

    public static boolean isPalindrome(String sub){
        for(int i =0, j = sub.length()-1 ; i<j ; i++, j--){
            if(sub.charAt(i) != sub.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("cccaacbcaabb"));
    }

}
