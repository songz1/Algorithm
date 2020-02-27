/*
송지은_백준 알고리즘 2583번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2583 {
	static int[][] graph;
	static int count = 0;
	static int M, N;
	static String size = "";

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		M = Integer.parseInt(stringTokenizer.nextToken());
		N = Integer.parseInt(stringTokenizer.nextToken());
		int K = Integer.parseInt(stringTokenizer.nextToken());

		graph = new int[N][M];
		for (int i = 0; i < K; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int x1 = Integer.parseInt(stringTokenizer.nextToken());
			int y1 = Integer.parseInt(stringTokenizer.nextToken());
			int x2 = Integer.parseInt(stringTokenizer.nextToken());
			int y2 = Integer.parseInt(stringTokenizer.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					graph[x][y] = 1;
				}
			}
		}

		int num = 0;
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (graph[x][y] == 0) {
					DFS(x, y);
					size = size + count + " ";
					count = 0;
					num++;
				}
			}
		}

		int[] result = new int[num];
		String[] temp = size.split(" ");
		for (int i = 0; i < num; i++) {
			result[i] = Integer.parseInt(temp[i]);
		}
		Arrays.sort(result);

		System.out.println(num);
		for (int i = 0; i < num; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static void DFS(int x, int y) {
		graph[x][y] = 1;
		count++;

		if (x < N - 1 && graph[x + 1][y] == 0) {
			DFS(x + 1, y);
		}
		if (x > 0 && graph[x - 1][y] == 0) {
			DFS(x - 1, y);
		}
		if (y < M - 1 && graph[x][y + 1] == 0) {
			DFS(x, y + 1);
		}
		if (y > 0 && graph[x][y - 1] == 0) {
			DFS(x, y - 1);
		}
	}
}
