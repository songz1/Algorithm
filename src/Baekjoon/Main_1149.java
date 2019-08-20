/*
송지은_백준 알고리즘 1149번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int[][] price = new int[N][3];
		int[][] dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		dp[0][0] = price[0][0];
		dp[0][1] = price[0][1];
		dp[0][2] = price[0][2];

		for (int i = 1; i < N; i++) {
			dp[i][0] = (dp[i - 1][1] > dp[i - 1][2] ? dp[i - 1][2] : dp[i - 1][1]) + price[i][0];
			dp[i][1] = (dp[i - 1][0] > dp[i - 1][2] ? dp[i - 1][2] : dp[i - 1][0]) + price[i][1];
			dp[i][2] = (dp[i - 1][0] > dp[i - 1][1] ? dp[i - 1][1] : dp[i - 1][0]) + price[i][2];
		}

		int minimum = dp[N - 1][0];
		minimum = minimum > dp[N - 1][1] ? dp[N - 1][1] : minimum;
		minimum = minimum > dp[N - 1][2] ? dp[N - 1][2] : minimum;

		System.out.print(minimum);
	}
}
