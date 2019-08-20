/*
송지은_백준 알고리즘 1932번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= i + 1; j++) {
				if (j == 0) {
					dp[i + 1][j] = dp[i][j] + dp[i + 1][j];
				} else if (j == i + 1) {
					dp[i + 1][j] = dp[i][j - 1] + dp[i + 1][j];
				} else {
					dp[i + 1][j] = dp[i][j - 1] + dp[i + 1][j] > dp[i][j] + dp[i + 1][j] ? dp[i][j - 1] + dp[i + 1][j] : dp[i][j] + dp[i + 1][j];
				}
			}
		}

		int max = -1;
		for (int i = 0; i < n; i++) {
			max = dp[n - 1][i] > max ? dp[n - 1][i] : max;
		}

		System.out.println(max);
	}
}
