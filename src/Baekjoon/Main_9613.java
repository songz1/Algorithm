/*
송지은_백준 알고리즘 9613번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9613 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int n = Integer.parseInt(stringTokenizer.nextToken());

			int[] arr = new int[n];
			long GCD = 0;
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(stringTokenizer.nextToken());

				if (j != 0) {
					int temp = arr[j];
					for (int w = j - 1; w >= 0; w--) {
						int small = temp < arr[w] ? temp : arr[w];

						for (int q = small; q >= 1; q--) {
							if (temp % q == 0 && arr[w] % q == 0) {
								GCD += (long) q;
								break;
							}
						}
					}
				}
			}

			System.out.println(GCD);
		}
	}
}
