package InterviewBit.PrimeNumber;

//
// We can say that factorial of any number between two consecutive prime number,
// say (x, y) will have equal set of prime numbers as that of set of prime numbers in x.
// Since the factorial of x will contain all prime number less than equal to x.
//
// We will store all the prime number less than equal to highest value in the given array in a sorted order in an auxilary array, say v.
//
// Iterate over all prime number in array v and for each v[i], count the number of values in the array which are less than v[i].
// Let cnt denotes that value of each prime number v[i].
//
// All the subsequences of this will be pow(2, cnt) - 1.
//
// Sum all the values and return the answer.
//
// Note that we are talking of non-empty set. So the number 1 will be discarded.
//

import java.util.Arrays;

public class FactorialArray {
//    public static int solve(int[] A) {
//        int big = -1;
//        int mod = 1000000007;
//        for(int i =0 ;i<A.length; i++)
//            if(big<A[i])
//                big = A[i];
//        int[] primeNo = new int[big+1];
//        for(int i =2; i<=big; i++){
//            for(int j = 2 ; j*i<=big; j++){
//                primeNo[j*i] = 1;
//            }
//        }
//        int subsequences = 0;
//        for (int i = big; i>=2;i--){
//            if(primeNo[i] == 0){
//                int count = 0;
//                for(int j = 0; j<A.length;j++){
//                    if(i<A[j]){
//                        count++;
//                    }
//                }
//                subsequences+= (Math.pow(2, count) -1)%mod;
////                break;
//            }
//        }
//        return subsequences;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(solve(new int[]{2,3,4,5,6}));
//    }

//Final Solution
private int[] prime = new int[1000001];
    private int mod = 1000 * 1000 * 1000 + 7;

    public void pre(){
        int maxN = 1000001;
        prime[1] = 1;
        for(int i = 2; i < maxN; i++){
            if(prime[i] == 0){
                for(int j = 2 * i; j < maxN; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }

    public int power(long x, long y){
        long res = 1;
        while(y != 0){
            if(y % 2 == 1){
                res = (x * res) % mod;
            }
            y /= 2;
            x = (x * x) % mod;
        }
        return (int)res;
    }

    public int solve(int[] A) {
        pre();
        int n = A.length;
        Arrays.sort(A);
        //sort(A.begin(), A.end());
        int v[] = new int[100000], itr = 0;
        for(int i = 2; i <= A[n-1]; i++) {
            if(prime[i] == 0){
                v[itr] = i;
                itr++;
            }
        }

        long ans = 0;
        int j = 0, i = 0;
        while(i < n && j < itr) {
            int cnt =0;
            if(A[i] == 1){
                i++;
                continue;
            }
            while(i < n && A[i] < v[j]) {
                i++;
                cnt++;
            }
            long temp = power(2, cnt) - 1;
            temp += mod;
            temp %= mod;
            ans += temp;
            ans %= mod;
            j++;
        }
        if(i < n){
            long temp = power(2, n - i) -1;
            temp += mod;
            temp %= mod;
            ans += temp;
            ans %= mod;
        }
        return (int)ans;
    }
}
