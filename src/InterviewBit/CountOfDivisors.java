package InterviewBit;

public class CountOfDivisors {

    public static int[] solve(int[] A) {
        int[] divisors = new int[1000001];
        for (int i = 2; i <=1000000; i++) {
            for (int j = 1; j*i <= 1000000  && j*i >0 ; j++) {
                divisors[j*i] = divisors[j*i] + 1;
            }
        }
        int[] count = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            count[i]= divisors[i] +1;
        }
        return count;
    }

    public static void main(String[] args) {
        solve(new int[]{ 2, 3, 4, 5 });
    }

}
