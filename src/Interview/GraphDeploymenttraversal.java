package Interview;

import java.util.HashMap;
import java.util.Map;

public class GraphDeploymenttraversal {

    public static void main(String[] args) {

    }

    public int graphTraverse(int[][] graph, int[] result, int currentIndex, int[] visited, int order){
        if(visited[currentIndex] ==1){
            return order;
        }
        int currOrder = order;
        for (int i=0; i<graph[currentIndex].length; i++){
            if(!(visited[graph[currentIndex][i]] == 1)){
                 currOrder = graphTraverse(graph, result, graph[currentIndex][i], visited, currOrder);
            }
        }
        visited[currentIndex] = 1;
        result[currOrder] = currentIndex;
        return currOrder+1;
    }

//    public int arrowCount(int[] balloons){
//        Map<Integer, Integer> arrow = new HashMap<>();
//        int numArrows = 0;
//        for(int i = 0; i<balloons.length; i++){
//            Integer arrowsAtHeight = arrow.get(balloons[i] +1);
//            if(arrowsAtHeight == null || arrowsAtHeight ){
//                numArrows ++;
//                arrow.put(balloons[i], 1 );
//            }else{
//                int arrowsAtHeight = arrow.get(balloons[i] +1);
//                arrow.put(balloons[i] +1, arrowsAtHeight-1);
//            }
//        }
//    }
}
// result [ 2, 4 ,5, 3, 1]

// sum divisible by A in sum of pair in A
//public class Solution {
//    public int solve(int[] A, int B) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for(int i =0; i<B; i++){
//            map.put(i, new ArrayList<Integer>());
//        }
//        for(int i =0 ; i<A.length; i++){
//            map.get(A[i]%B).add(A[i]);
//        }
//        int sumOfPairs = 0;
//        sumOfPairs += nC2(map.get(0).size())%1000000007;
//        for(int i =1; i<= B/2 ; i++){
//            if(i == (B-i)){
//                sumOfPairs = (sumOfPairs%1000000007 + nC2(map.get(i).size())%1000000007)%(1000000007);
//            }else{
//                sumOfPairs = (sumOfPairs%1000000007 + ((map.get(i).size())%1000000007*map.get(B-i).size()%1000000007)%(1000000007))%1000000007;
//            }
//        }
//        return sumOfPairs;
//    }
//
//    public int nC2(int n){
//        return n*(n-1)/2;
//    }
//}
