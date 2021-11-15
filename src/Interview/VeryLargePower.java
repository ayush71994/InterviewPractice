package Interview;

import java.util.HashMap;
import java.util.Map;

public class VeryLargePower {
    // Using property (a^b)%n = (a^r) % n
    // where r = b % n-1
    public int solve(int A, int B) {
        int mod = 1000000007;
        Map<Long, Long> memoization = new HashMap<Long, Long>();
        memoization.put(0L, (long) 1);
        memoization.put(1L, (long) (A % mod));
        return (int) (power(A, factorialMod(B,mod -1), mod, memoization) % mod);
    }

    public static long power(long base, long power, long mod, Map<Long, Long> memoization) {
        if (memoization.get(power) != null) {
            return memoization.get(power);
        }
        long result;
        if (power % 2 == 0) {
            result = power(base, power / 2, mod, memoization) * power(base, power / 2, mod, memoization);
        } else {
            result = (base * ((power(base, (power - 1) / 2, mod, memoization) * power(base, (power - 1) / 2, mod, memoization))% mod));
        }
        result = result % mod;
        memoization.put(power, result);
        return result;
        // return ((int)Math.pow(base, power));
    }

    public static long factorialMod(long num, long mod){
        long result = 1;
        while (num >1){
            result  = (result * num) % mod;
            num --;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
