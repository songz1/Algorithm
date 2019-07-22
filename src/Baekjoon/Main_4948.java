/*
송지은_백준 알고리즘 4948번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4948 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(bufferedReader.readLine());

			if (n == 0) {
				break;
			}

			int[] arr = new int[2 * n + 1];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 0;
			}
			arr[1] = 1;

			for (int i = 2; i < arr.length; i++) {
				for (int j = 2; i * j <= 2 * n; j++) {
					arr[i * j] = 1;
				}
			}

			int count = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (arr[i] != 1) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
