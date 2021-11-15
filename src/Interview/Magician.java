package Interview;

import static java.lang.Math.floor;

import java.util.Collections;
import java.util.PriorityQueue;

//https://www.interviewbit.com/problems/magician-and-chocolates/#
public class Magician {

    private final static int mod = 1000000007;

    public static int nchoc(int X, int[] A, double M) {

        if(X < 1 || A.length == 0) return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        for(int i = 0; i < A.length; i++) maxHeap.add(A[i]);

        long ans = 0;

        while(X != 0 && maxHeap.peek() != 0){
            int numChoc = maxHeap.remove();
            ans = (ans + numChoc) % mod;
            maxHeap.add((int) floor(numChoc*M));
            X--;
        }

        return (int)(ans%mod);
    }

//    public static void main(String[] args)
//    {
//        System.out.println(nchoc(5, new int[]{4,8,6,2,10}, 0.5));
//    }



    public static int  maxDaysToWork(int[] countTown)
    {
        int  answer = 0;
        // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<countTown.length; i++){
            maxHeap.add(countTown[i]);
        }

        while(maxHeap.size() > 1){
            int currMax = maxHeap.remove();
            int secondMax = maxHeap.remove();
            answer += secondMax;
            maxHeap.add(currMax - secondMax);
        }
        if(maxHeap.peek() > 0) answer++;

            return answer;
    }

//    public static void main(String[] args)
//    {
//        Scanner in = new Scanner(System.in);
//        //input for countTown
//        int countTown_size = in.nextInt();
//        int countTown[] = new int[countTown_size];
//        for(int idx = 0; idx < countTown_size; idx++)
//        {
//            countTown[idx] = in.nextInt();
//        }
//
//        int result = maxDaysToWork(countTown);
//        System.out.print(result);
//
//    }
}
