/*
송지은_최대값 찾기(재귀)
*/

package Study;

public class Main_0 {
    public static void main(String[] args){
        int[] scores = {76, 35, 98, 64, 87, 54, 100};

        int max = maxScore(scores, 0, scores.length);
        System.out.println(max);
    }

    public static int maxScore(int[] scores, int start, int end){
        if(start == end)
            return 0;
        return Math.max(scores[start], maxScore(scores, start+1, end));
    }

}


