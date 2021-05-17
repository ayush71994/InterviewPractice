package MayChallenge;

public class CardPoints {

    public static int maxScore(int[] cardPoints, int k) {
        int totalPoints = 0;
        for (int cardPoint : cardPoints) {
            totalPoints += cardPoint;
        }
        int windowLength = cardPoints.length - k;
        int startIndex = 0;
        int endIndex = windowLength -1 ;
        int windowSum = 0;
        for (int i = startIndex; i < windowLength; i++) {
            windowSum += cardPoints[i];
        }
        int answer = Math.max(0, totalPoints - windowSum);
        for (; endIndex <cardPoints.length - 1; startIndex++, endIndex++) {
            windowSum = windowSum - cardPoints[startIndex] + cardPoints[endIndex + 1];
            answer = Math.max(answer, totalPoints - windowSum);
        }
        return answer;
    }

    public static void main(String args[]) {
        int[] points = new int[]{11, 49, 100, 20, 86, 29, 72};
        System.out.println(maxScore(points, 4));
    }
}

//        [11,49,100,20,86,29,72]
//            4
//            232