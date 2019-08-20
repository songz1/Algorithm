/*
송지은_백준 알고리즘 1463번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1463 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] count = new int[N + 1];
		count[0] = 0;
		count[1] = 0;

		for (int i = 2; i <= N; i++) {
			count[i] = count[i - 1] + 1;
			if (i % 2 == 0) {
				count[i] = count[i] > count[i / 2] + 1 ? count[i / 2] + 1 : count[i];
			}
			if (i % 3 == 0) {
				count[i] = count[i] > count[i / 3] + 1 ? count[i / 3] + 1 : count[i];
			}
		}

		System.out.println(count[N]);
	}
}
