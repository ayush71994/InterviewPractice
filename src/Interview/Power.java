package Interview;

import java.util.HashMap;
import java.util.Map;

public class Power {

    public static int solve(int A, int B) {
        Map<Long, Long> memoization = new HashMap<Long, Long>();
        memoization.put(0L, (long) 1 % B);
        memoization.put(1L, (long) (A % B));
        return (int) (power(A, B - 2, B, memoization) % B);
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

    public static long power2(long base, long power, long mod, Map<Long, Long> memoization) {
        long result = base;
        for (int i = 2; i <= power; i++) {
            result = (result * base) % mod;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(solve(10000007, 100000007));// 58730163
    }

}
