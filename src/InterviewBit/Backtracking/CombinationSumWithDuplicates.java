package InterviewBit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumWithDuplicates {
    static ArrayList<ArrayList<Integer>> result;
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result = new ArrayList<>();
        Collections.sort(A);
        allCombinationsWithSum(A,B,new ArrayList<Integer>(),0,0);
        return result;
    }

    public static void allCombinationsWithSum(ArrayList<Integer> A, int B, ArrayList<Integer> curr, int currSum, int currentInd){
        if(currSum == B){
            result.add(new ArrayList<>(curr));
            return;
        }
        int currSize = curr.size();
        int currElement = -1;
        for(int i =0; i<A.size();i++){
            if(((currSum+A.get(i)) <= B)&& (currSize == 0 || A.get(i)>=curr.get(currSize-1)) && A.get(i)!=currElement){
                currElement = A.get(i);
                curr.add(A.get(i));
                allCombinationsWithSum(A, B, curr, currSum+A.get(i),currentInd+1);
                curr.remove(currentInd);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new ArrayList<Integer>() {
            { add(8);add(10); add(6); add(11); add(1); add(16); add(8);}
        }, 28));
    }
}

// Alternate easier approach



//public class Solution {
//    ArrayList < ArrayList < Integer >> res;
//    public ArrayList < ArrayList < Integer >> combinationSum(ArrayList < Integer > A, int B) {
//        res = new ArrayList < > ();
//        ArrayList < Integer > unique = new ArrayList < > ();
//        if (A == null)
//            return res;
//        Collections.sort(A);
//        unique.add(A.get(0));
//        for (int i = 0; i < A.size(); i++) {
//            if (i != 0 && A.get(i) != A.get(i - 1))
//                unique.add(A.get(i));
//        }
//        combinationSum(unique, new ArrayList < > (), B, 0);
//        return res;
//    }
//
//    public void combinationSum(ArrayList < Integer > A, ArrayList < Integer > res, int B, int index) {
//        if (B == 0) {
//            this.res.add(new ArrayList(res));
//            return;
//        }
//        if (B < 0)
//            return;
//        for (int i = index; i < A.size(); i++) {
//            int num = A.get(i);
//            res.add(num);
//            combinationSum(A, res, B - num, i);
//            res.remove(res.size() - 1);
//        }
//    }
//}