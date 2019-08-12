/*
송지은_백준 알고리즘 1912번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int max = arr[0];
		result[0] = arr[0];
		for (int i = 1; i < n; i++) {
			result[i] = (result[i - 1] + arr[i]) >= arr[i] ? (result[i - 1] + arr[i]) : arr[i];
			max = max >= result[i] ? max : result[i];
		}

		System.out.print(max);
	}
}
