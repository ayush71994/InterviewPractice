package InterviewBit.BitManipulation;

// Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
// Note: Output array must be sorted.
//
//  Sol.
// - XOR of all numbers to identify bits which are varying between the two single numbers
//   After XOR all bits with 1 would be different in the pair of single numbers,
//   because duplicate numbers are cancelling the XOR, 1 is coming due to one of the single number
// - For a bit which is different, one number would have 0 and one would have 1 thus,
//   we can divide the numbers in the array with the chosen bit as 1 & 0  into 2 sets
//   and the XOR of the numbers in the sets gives the answers

public class PairOfSingleNumInArray {
    public int[] solve(int[] A) {
        int xor = 0;
        for(int i =0; i<A.length; i++){
            xor = xor^A[i];
        }
        // identify differing bit
        int diffBit = 0;
        for(int i=0;i<32;i++){
            if((xor&(1<<i)) > 0){
                diffBit = i;
                break;
            }
        }
        // Take Xor of all numbers with differing bit as 1 and 0
        int num1 = 0, num2 = 0;
        for(int i =0; i<A.length;i++){
            if((A[i]&(1<<diffBit)) == 0){
                num1 ^=A[i];
            }else{
                num2 ^=A[i];
            }
        }
        int[] ans = new int[2];

        ans[0] = Math.min(num1, num2);
        ans[1] = Math.max(num1, num2);
        return ans;

    }

}
