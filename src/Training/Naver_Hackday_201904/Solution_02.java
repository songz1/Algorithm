/*
송지은_네이버 핵데이 코딩테스트_2번(미완료)
*/

package Training.Naver_Hackday_201904;

public class Solution_02 {
    public static void main(String[] args) {
        int[] A = {1, 6, 2, 3, 6};
        System.out.println();
    }

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T) {
        int count = 0;
        int[] temp = new int[3501];
        boolean exist = false;

        if (T.l != null) solution(T.l);
        else if (T.r != null) solution(T.r);

        int tempCount;
        for (int i = 0; i < temp.length; i++) {
            if (i != 0 && temp[i] == 0) break;
            if (temp[i] == T.x) {
                exist = true;
                break;
            }
        }
        if (exist == false) temp[count++] = T.x;

        return count;
    }
}
