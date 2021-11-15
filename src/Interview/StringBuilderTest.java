package Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringBuilderTest {

    public String solve(String A) {
            StringBuilder answer =  new StringBuilder("");
            for (int i =0; i<A.length(); i++){
                char current = A.charAt(i);
                answer.append(current);
                answer.append((current - 97));
            }
            return answer.toString();
        }

    public int[] solve3(int[] A){

        // int greatestIndex= A[0]> A[1] ? 0 :1 ;
        // int secondGreatestIndex= A[0]< A[1] ? 0 :1 ;
        int greatestIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[greatestIndex] < A[i]) {
                greatestIndex = i;
            }
        }
        int secondGreatestIndex = greatestIndex == 0 ? 1 : 0;
        for (int i = 0; i < A.length; i++) {
            if (i != greatestIndex && A[secondGreatestIndex] < A[i]) {
                secondGreatestIndex = i;
            }
        }
        int[] elements =new int[A.length -2];
        for (int i = 0, j=0; i < A.length; i++) {
            if (i != greatestIndex && i != secondGreatestIndex) {
                elements[j] = A[i];
                j++;
            }
        }

        return elements;
    }
}
