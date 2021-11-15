package InterviewBit;

//https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
public class SortedPermutationRank {
    public static int findRank(String A) {
        int currRank = 1;
        for(int i = 0; i<A.length(); i++){
            int smallerCharacters = numberOfCharactersSmaller(A,i);
            System.out.println("smallerCharacters : " + smallerCharacters);
            currRank = (currRank + (smallerCharacters * factorial(A.length() - 1 - i)%1000003))%1000003;
            System.out.println("currRank : " + currRank);
        }
        return currRank;
    }

    private static int numberOfCharactersSmaller(String str, int currIndex){
        char curr = str.charAt(currIndex);
        int count = 0;
        for(int i = currIndex + 1;i<str.length();i++){
            if(str.charAt(i) < curr){
                count++;
            }
        }
        return count;
    }

    private static int factorial(int length) {
        int ans =1;
        for(int i = 2; i<=length;i++){
            ans= (ans *i) % 1000003;
        }
        System.out.println("Length: "+length+" Factorial: " + ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findRank("DTNGJPURFHYEW"));
    }

}
