/*
송지은_백준 알고리즘 1783번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1783 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        if (N == 1) {
            System.out.print(1);
        } else if (N == 2) {
            System.out.print(Math.min(4, (M + 1) / 2));
        } else {
            if (M >= 7) {
                System.out.print(M - 2);
            } else {
                System.out.print(Math.min(4, M));
            }
        }
    }
}
