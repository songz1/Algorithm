/*
송지은_백준 알고리즘 9095번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());

		int[] arr = new int[12];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int j = 4; j < 11; j++) {
			arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(bufferedReader.readLine());

			System.out.println(arr[n]);
		}
	}
}
