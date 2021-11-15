package InterviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


//Reference: https://www.geeksforgeeks.org/find-original-numbers-from-gcd-every-pair/
public class AllGCDPair {

    public static int[] solve(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> removal = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int resultSize = (int)Math.sqrt(A.length);

        for (int i = A.length - 1; i > 0 && result.size()<resultSize ; i--) {
            if (removal.containsKey(A[i]) && removal.get(A[i]) > 0) {
                removal.put(A[i], removal.get(A[i]) - 1);
                continue;
            } else {
                result.add(A[i]);
                Iterator<Integer> it = result.iterator();
                while(it.hasNext()) {
                    int gcd = gcd(A[i], it.next());
                    removal.put(gcd, removal.getOrDefault(gcd, 0) + 2);
                }
            }
        }

        int[] resultArray = new int[result.size()];
        Iterator<Integer> it = result.iterator();
        for (int i = 0; it.hasNext(); i++) {
            resultArray[i] = it.next();
        }
        return resultArray;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{46, 1, 2, 1, 1, 1, 5, 45, 1, 1, 2, 5, 1, 40, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31, 1}));
        return;
    }
}
