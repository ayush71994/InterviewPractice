package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CombinationSumWithoutDuplicates {
    static ArrayList<ArrayList<Integer>> result;
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result = new ArrayList<>();
        Collections.sort(A);
        allCombinationsWithSum(A,B,new ArrayList<Integer>(),0,0,0);
        return result;
    }

    public static void allCombinationsWithSum(ArrayList<Integer> A, int B, ArrayList<Integer> curr, int start,int currSum, int currentInd){
        if(currSum == B){
            result.add(new ArrayList<>(curr));
            return;
        }
        int currSize = curr.size();
        int currElement = -1;
        for(int i =start; i<A.size();i++){
            if(((currSum+A.get(i)) <= B)&& (currSize == 0 || A.get(i)>=curr.get(currSize-1)) && A.get(i)!=currElement){
                curr.add(A.get(i));
                currElement = A.get(i);
                allCombinationsWithSum(A, B, curr, i+1,currSum+A.get(i),currentInd+1);
                curr.remove(currentInd);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new ArrayList<Integer>() {
            { add(15);add(8); add(15); add(10); add(19); add(18); add(10); add(3); add(11); add(7); add(17);}
        }, 33));
    }
}
