package Scaler;

public class Fibonacci {

    public static void main(String[] args) {
        int n =10;
        System.out.println(getFibonacci(n));
    }

    private static int getFibonacci(int n) {
        int first = 1;
        int second = 1;
        int answer = 1;
        for (int i = 3;i<=n;i++){
            answer = first + second;
            first = second;
            second = answer;
        }
        return answer;
    }

}
