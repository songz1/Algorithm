/*
송지은_백준 알고리즘 2167번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2167 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		int[][] arr = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		int i, j, x, y;
		int K = Integer.parseInt(bufferedReader.readLine());
		for (int a = 0; a < K; a++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			i = Integer.parseInt(stringTokenizer.nextToken());
			j = Integer.parseInt(stringTokenizer.nextToken());
			x = Integer.parseInt(stringTokenizer.nextToken());
			y = Integer.parseInt(stringTokenizer.nextToken());

			int sum = 0;
			for (int b = i; b <= x; b++) {
				for (int c = j; c <= y; c++) {
					sum += arr[b][c];
				}
			}

			System.out.println(sum);
		}
	}
}
