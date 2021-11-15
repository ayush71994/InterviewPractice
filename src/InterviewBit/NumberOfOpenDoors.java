package InterviewBit;

public class NumberOfOpenDoors {
    public static int solve(int A) {
        boolean[] doors = new boolean[A + 1];
        for (int i = 2; i <= A; i++) {
            for (int j = i; j <= A; j+=i) {
                doors[j] = !doors[j];
            }
        }
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (!doors[i]) {
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static int solve2(int A) {
        boolean[] doors = new boolean[A + 1];
        int count =0;
        for (int i = 1; i*i <= A; i++) {
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("solve: "+solve(100));
    }
}
