/*
송지은_SW 알고리즘 8993번
*/

package SW_Expert_Academy;

import java.util.Scanner;

public class Solution_8993 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            long N = scanner.nextLong();
            Boolean check = true;

            while (N > 1) {
                if (N % 2 == 1) {
                    check = false;
                    break;
                }

                if (N % 2 == 0) {
                    N = N / 2;
                } else {
                    N = 3 * N + 3;
                }
            }

            if (check) {
                System.out.println("#" + i + " YES");
            } else {
                System.out.println("#" + i + " NO");
            }
        }
    }
}
