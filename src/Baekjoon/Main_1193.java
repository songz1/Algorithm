/*
송지은_백준 알고리즘 1193번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        int i, sum = 0;
        for (i = 1; sum + i < X; i++) {
            sum += i;
        }

        if (sum + i == X) {
            if (i % 2 == 0) {
                System.out.print(i + "/" + 1);
            } else {
                System.out.print(1 + "/" + i);
            }
        } else {
            if (i % 2 == 0) {
                System.out.print((X - sum) + "/" + (i - (X - sum) + 1));
            } else {
                System.out.print((i - (X - sum) + 1) + "/" + (X - sum));
            }
        }
    }
}
