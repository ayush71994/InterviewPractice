package InterviewBit;

public class PermutationsOfNLength {
    int filledIndex = 0;
    int[][] finalAns;
    public int[][] permute(int[] A) {
        finalAns = new int[factorial(A.length)][A.length];
        for(int i = 0; i<A.length; i++) {
            generatePerm(A,""+A[i]);
        }
        return finalAns;
    }

    public void generatePerm( int[] A, String currPerm){
        if(currPerm.length() == A.length){
            int[] list = new int[A.length];
            for(int i = 0 ; i< currPerm.length(); i++){
                list[i] = currPerm.charAt(i) - 48;
            }
            finalAns[filledIndex] = list;
            filledIndex ++;
            return;
        }
        for(int i =0 ;i<A.length;i++){
            if(!currPerm.contains(""+A[i])){
                generatePerm(A,currPerm+A[i]);
            }
        }
    }
    private int factorial(int length) {
        int ans =1;
        for(int i = 2; i<=length;i++){
            ans*=i;
        }
        return ans;
    }

}

//Another approach
//public class Solution {
//    private boolean[] marked;
//    private ArrayList < ArrayList < Integer >> res;
//    private ArrayList < Integer > A;
//    private int n;
//    public ArrayList < ArrayList < Integer >> permute(ArrayList < Integer > A) {
//        n = A.size();
//        marked = new boolean[n];
//        res = new ArrayList < > ();
//        this.A = A;
//        rec(0, new ArrayList < > ());
//        return res;
//    }
//    public void rec(int idx, ArrayList < Integer > temp) {
//        if (idx == n) {
//            res.add(new ArrayList < > (temp));
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (!marked[i]) {
//                marked[i] = true;
//                temp.add(A.get(i));
//                rec(idx + 1, temp);
//                marked[i] = false;
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//}
