/*
송지은_백준 알고리즘 1463번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 0;

		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + 1;

			if (i % 3 == 0) {
				arr[i] = arr[i] < arr[i / 3] + 1 ? arr[i] : arr[i / 3] + 1;
			}
			if (i % 2 == 0) {
				arr[i] = arr[i] < arr[i / 2] + 1 ? arr[i] : arr[i / 2] + 1;
			}
		}

		System.out.print(arr[n]);
	}
}
