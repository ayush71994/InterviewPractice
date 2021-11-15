package InterviewBit;

/*
Algo:
fibonacci follows [odd odd even odd odd even odd odd even odd odd even .... ]
hence if x is multiple of 3 then f(x) is even.
For calculating the number of odd f(x) between a range we calculate no. of even f(x) using the above property
then we subtract that with total range
 */
public class OddFibonacci {

    public int solve(int A, int B) {
        int evenCount =0;
        int nums = B-A+1;
        while (A<=B ){
            if(A%3 == 0){
                evenCount = (B-A)/3 + 1;
                break;
            }else{
                A+=1;
            }
        }
        int oddCount = nums - evenCount;
        return oddCount;
    }
}
