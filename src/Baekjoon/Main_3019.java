/*
송지은_백준 알고리즘 3019번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3019 {
	static int count = 0;
	static int[] height;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int C = Integer.parseInt(stringTokenizer.nextToken());
		int P = Integer.parseInt(stringTokenizer.nextToken());

		height = new int[C];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < C; i++) {
			height[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int[] r;

		if (P == 1 || P == 3 || P == 4) {
			r = rotation(P, 0);
			find(r, height);

			r = rotation(P, 90);
			find(r, height);
		} else if (P == 2) {
			r = rotation(P, 0);
			find(r, height);
		} else if (P == 5 || P == 6 || P == 7) {
			r = rotation(P, 0);
			find(r, height);

			r = rotation(P, 90);
			find(r, height);

			r = rotation(P, 180);
			find(r, height);

			r = rotation(P, 270);
			find(r, height);
		}

		System.out.print(count);
	}

	public static void find(int[] r, int[] height) {
		Boolean check = true;

		for (int i = 0; i <= height.length - r.length; i++) {
			for (int j = 0; j < r.length - 1; j++) {
				if (r[j + 1] - r[j] != height[i + j + 1] - height[i + j]) {
					check = false;
					break;
				} else {
					check = true;
				}
			}

			if (check) {
				count++;
			}
		}
	}

	public static int[] rotation(int P, int r) {
		switch (P) {
			case 1:
				if (r == 0 || r == 180) {
					int[] a = {0};
					return a;
				} else {
					int[] a90 = {0, 0, 0, 0};
					return a90;
				}

			case 2:
				int[] b = {0, 0};
				return b;

			case 3:
				if (r == 0 || r == 180) {
					int[] c = {0, 0, 1};
					return c;
				} else {
					int[] c90 = {1, 0};
					return c90;
				}

			case 4:
				if (r == 0 || r == 180) {
					int[] d = {1, 0, 0};
					return d;
				} else {
					int[] d90 = {0, 1};
					return d90;
				}

			case 5:
				if (r == 0) {
					int[] e = {0, 0, 0};
					return e;
				} else if (r == 90) {
					int[] e90 = {0, 1};
					return e90;
				} else if (r == 180) {
					int[] e180 = {1, 0, 1};
					return e180;
				} else {
					int[] e270 = {1, 0};
					return e270;
				}

			case 6:
				if (r == 0) {
					int[] f = {0, 0, 0};
					return f;
				} else if (r == 90) {
					int[] f90 = {0, 0};
					return f90;
				} else if (r == 180) {
					int[] f180 = {0, 1, 1};
					return f180;
				} else {
					int[] f270 = {2, 0};
					return f270;
				}

			case 7:
				if (r == 0) {
					int[] g = {0, 0, 0};
					return g;
				} else if (r == 90) {
					int[] g90 = {0, 2};
					return g90;
				} else if (r == 180) {
					int[] g180 = {1, 1, 0};
					return g180;
				} else {
					int[] g270 = {0, 0};
					return g270;
				}

			default:
				return new int[]{};
		}
	}
}
