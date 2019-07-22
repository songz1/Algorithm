/*
송지은_백준 알고리즘 1929번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1929 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();

		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = 0;
		}
		arr[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 2; i * j <= n; j++) {
				arr[i * j] = 1;
			}
		}

		for (int i = m; i <= n; i++) {
			if (arr[i] != 1) {
				System.out.println(i);
			}
		}
	}
}
