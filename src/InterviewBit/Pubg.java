package InterviewBit;

/*
 Algo:
 - When player[i] attacks j health of j reduces by i's strength
   We would never attack with stronger player if weaker players are present
   since then we would not be able to get min health
 - When player i attacks j then the remaining health between them would gcd(i's strength, j's strength)
 - We can keep on doing this for all the players and the last remaining gcd would be the answer
 */
public class Pubg {

    public int solve(int[] A) {
        int currGcd = A[0];
        int  min = A[0];
        for(int i = 1 ; i< A.length ; i++ ){
            currGcd = gcd(currGcd, A[i]);
            if(min > currGcd){
                min = currGcd;
            }
        }
        return min;
    }

    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

}
