/*
송지은_백준 알고리즘 2012번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2012 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(bufferedReader.readLine());
		}

		Arrays.sort(arr);

		long sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i != arr[i]) {
				sum += Math.abs(arr[i] - i);
			}
		}

		System.out.print(sum);
	}
}
