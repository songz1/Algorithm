package ESTsoft;

import java.util.Arrays;

public class Solution_01 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 5, 5, 5, 5}));  // 5
        System.out.println(solution(new int[]{3, 8, 2, 3, 3, 2}));  // 3
        System.out.println(solution(new int[]{7, 1, 2, 8, 2}));  // 2
    }

    public static int solution(int[] A) {
        Arrays.sort(A);

        int max = 0;
        int count, target;

        for (int i = 0; i < A.length; i++) {
            count = 0;
            target = A[i];
            for (int j = i; j < A.length; j++) {
                if (target != A[j]) {
                    i = j - 1;
                    break;
                }
                count++;
            }

            if (count == target) {
                max = max > target ? max : target;
            }
        }

        return max;
    }
}
