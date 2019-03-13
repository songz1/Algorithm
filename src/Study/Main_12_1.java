/*
송지은_N번째 행에 별 N개 출력(재귀) - 오른쪽 정렬
*/

package Study;

import java.util.Scanner;

public class Main_12_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("행 수를 입력하시오: ");
            int n = scanner.nextInt();
            print1(n);
            System.out.println();
            print2(n, 0, 0);
        }
    }

    static void print1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= (n - i - 1)) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void print2(int n, int i, int j) {
        if (i >= n) return;
        if (j < n) {
            if (j >= (n - i - 1)) System.out.print("*");
            else System.out.print(" ");
            print2(n, i, ++j);
        } else {
            System.out.println();
            print2(n, ++i, 0);
        }
    }
}

