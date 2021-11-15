package InterviewBit.Backtracking;

import java.util.ArrayList;

public class NQueen {
    static ArrayList<ArrayList<String>> result;
    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        result = new ArrayList<>();
        if(a>1 && a<4) return result;
        solveNQueen(a, 0,new int[a][a],new ArrayList<Integer>());
        return result;
    }

    public static void solveNQueen(int a, int currRow, int[][] currBoard, ArrayList<Integer> col ){
        if(currRow == a){
            ArrayList<String> board = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                String str = "";
                for (int j = 0; j < a; j++) {
                    if(currBoard[i][j] == 1){
                        str = str +"Q";
                    }else {
                        str = str + ".";
                    }
                }
                board.add(str);
            }
            result.add(board);
            return;
        }
        for( int i =0 ; i<a ; i++) {
            if (currRow == 0 || (!col.contains(i) && checkDiagonalNotConflicting(currBoard, currRow, i))) {
                currBoard[currRow][i] = 1;
                col.add(i);
                solveNQueen(a, currRow + 1, currBoard, col);
                col.remove(col.size() - 1);
                currBoard[currRow][i] = 0;
            }
        }
    }

    private static boolean checkDiagonalNotConflicting(int[][] currBoard, int currRow, int currCol) {
        for(int i = currRow - 1, j=1; i >=0; i--, j++){
            int left = currCol - j;
            int right = currCol + j;
            if( left>=0 && currBoard[i][left] == 1){
                return false;
            }
            if(right < currBoard.length && currBoard[i][right] == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }
}
