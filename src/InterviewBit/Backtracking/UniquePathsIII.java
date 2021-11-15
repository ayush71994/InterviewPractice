package InterviewBit.Backtracking;

public class UniquePathsIII {
    static int count;
    public static int solve(int[][] A) {
        int currX =0 ,currY =0;
        count = 0;
        for(int i = 0; i<A.length; i++){
            for(int j =0 ; j<A[i].length;j++){
                if(A[i][j] ==1){
                    currX = i;
                    currY = j;
                    A[currX][currY] = 0;
                }
            }
        }
        countPaths(A,currX, currY);
        return count;
    }

    public static void countPaths(int[][] A, int currX, int currY){
        if(A[currX][currY] == -1 || A[currX][currY] == 1){
            return;
        }
        else if(A[currX][currY] == 2){
            if(allPathsTraversed(A)){
                count++;
            }
            return;
        }else if(A[currX][currY] == 0){
            A[currX][currY] = 1;
            //up
            if(currX>0){
                countPaths(A, currX-1, currY);
            }
            //down
            if(currX<(A.length-1)){
                countPaths(A, currX+1, currY);
            }
            //left
            if(currY>0){
                countPaths(A, currX, currY-1);
            }
            //right
            if(currY<(A[0].length-1)){
                countPaths(A, currX, currY+1);
            }
            A[currX][currY] = 0;
        }

    }

    private static boolean allPathsTraversed(int[][] a) {
        for(int i = 0; i<a.length; i++){
            for(int j =0 ; j<a[i].length;j++){
                if(a[i][j] ==0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        }));
        System.out.println(solve(new int[][]{
            {0, 1},
            {2, 0}
        }));
    }
}
