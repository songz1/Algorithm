/*
송지은_백준 알고리즘 11057번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11057 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[][] dp = new int[n + 1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}

		for (int i = 2; i < n + 1; i++) {
			for (int k = 0; k < 10; k++) {
				for (int j = k; j < 10; j++) {
					dp[i][k] += dp[i - 1][j];
					dp[i][k] %= 10007;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}

		System.out.print(sum % 10007);
	}
}
