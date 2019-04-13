/*
송지은_네이버 핵데이 코딩테스트_1번(완료)
*/

package Training;

public class NaverHackday_201904_01 {
    public static void main(String[] args) {
        int[] A = {1, 6, 2, 3, 6};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int count = -1;
        int pivot;

        for (int i = 0; i < A.length; i++) {
            int tempCount = 0;
            pivot = A[i];
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    if ((pivot + A[j]) == 7) tempCount = tempCount + 2;
                    else {
                        if (pivot != A[j]) ++tempCount;
                    }
                }
            }
            if (count == -1 || tempCount < count) count = tempCount;
        }
        return count;
    }
}
