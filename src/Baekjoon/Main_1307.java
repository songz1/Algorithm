/*
송지은_백준 알고리즘 1307번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1307 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[][] m = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = 0;
			}
		}

		if (n % 2 != 0) {
			int a = n - 1;
			int b = n / 2;
			m[a][b] = 1;

			for (int i = 2; i <= n * n; i++) {
				a = a + 1;
				b = b + 1;

				if (a >= n && b >= n) {
					a = a - 2;
					b = b - 1;
					m[a][b] = i;
				} else if (a >= n) {
					a = 0;
					m[a][b] = i;
				} else if (b >= n) {
					b = 0;
					m[a][b] = i;
				} else if (m[a][b] != 0) {
					a = a - 2;
					b = b - 1;
					m[a][b] = i;
				} else {
					m[a][b] = i;
				}
			}
		} else {
			if (n % 4 == 0) {
				int value = 1;
				int count = 0;
				int[] temp = new int[n * n / 2];
				int range = n / 4;

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (i < range || i >= n - range) {
							if (j < range || j >= n - range) {
								m[i][j] = value++;
							} else {
								temp[count++] = value++;
							}
						} else if (j < range || j >= n - range) {
							if (i < range || i >= n - range) {
								m[i][j] = value++;
							} else {
								temp[count++] = value++;
							}
						} else {
							m[i][j] = value++;
						}
					}
				}

				count = 0;
				for (int i = n - 1; i >= 0; i--) {
					for (int j = n - 1; j >= 0; j--) {
						if (m[i][j] == 0) {
							m[i][j] = temp[count++];
						}
					}
				}
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
