package ESTsoft;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        int answer = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] == answer) {
                answer++;
            } else if (A[i] > 0 && A[i] > answer) {
                break;
            }
        }

        return answer;
    }
}
