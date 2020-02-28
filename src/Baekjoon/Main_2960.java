/*
송지은_백준 알고리즘 2960번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_2960 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();

		int[] prime = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			prime[i] = i;
		}

		int result;
		for (int m = 2; m < prime.length; m++) {
			for (int i = m; i < prime.length; i++) {
				if (prime[i] != 0 && prime[i] % m == 0) {
					prime[i] = 0;
					result = i;
					K--;
					if (K <= 0) {
						System.out.print(result);
						return;
					}
				}
			}
		}
	}
}

