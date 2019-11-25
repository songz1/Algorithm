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

		reset(m, n);

		if (n % 2 != 0) {
			oddNumber(m, n, 1);
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
			} else if (n % 4 == 2) {
				int range = n / 2;
				int[][] section = new int[range][range];

				reset(section, range);
				oddNumber(section, range, 1);
				for (int i = 0; i < range; i++) {
					for (int j = 0; j < range; j++) {
						m[i][j] = section[i][j];
					}
				}

				reset(section, range);
				oddNumber(section, range, range * range + 1);
				for (int i = range; i < range * 2; i++) {
					for (int j = range; j < range * 2; j++) {
						m[i][j] = section[i - range][j - range];
					}
				}

				reset(section, range);
				oddNumber(section, range, range * range * 2 + 1);
				for (int i = range; i < range * 2; i++) {
					for (int j = 0; j < range; j++) {
						m[i][j] = section[i - range][j];
					}
				}

				reset(section, range);
				oddNumber(section, range, range * range * 3 + 1);

				swap(m, section, range / 2, range / 2);
				for (int i = 0; i < range; i++) {
					for (int j = 0; j < range; j++) {
						if (j != range / 2) {
							swap(m, section, i, j);
						}
					}
				}

				for (int i = 0; i < range; i++) {
					for (int j = range; j < range * 2; j++) {
						m[i][j] = section[i][j - range];
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

	static void reset(int[][] m, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = 0;
			}
		}
	}

	static void swap(int[][] a, int[][] b, int row, int hor) {
		int temp = b[row][hor];
		b[row][hor] = a[row][hor];
		a[row][hor] = temp;
	}

	static void oddNumber(int[][] m, int n, int start) {
		int a = n - 1;
		int b = n / 2;
		m[a][b] = start++;

		for (int i = 2; i <= n * n; i++) {
			a = a + 1;
			b = b + 1;

			if (a >= n && b >= n) {
				a = a - 2;
				b = b - 1;
				m[a][b] = start++;
			} else if (a >= n) {
				a = 0;
				m[a][b] = start++;
			} else if (b >= n) {
				b = 0;
				m[a][b] = start++;
			} else if (m[a][b] != 0) {
				a = a - 2;
				b = b - 1;
				m[a][b] = start++;
			} else {
				m[a][b] = start++;
			}
		}
	}
}
