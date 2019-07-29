/*
송지은_백준 알고리즘 11403번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11403 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[][] graph = new int[n][n];
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(stringTokenizer.nextToken());

				if (temp == 1) {
					graph[i][j] = 1;
				} else {
					graph[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(visited, false);
			dfs(i, visited, graph);

			for (int j = 0; j < n; j++) {
				if (visited[j]) {
					graph[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void dfs(int i, boolean[] visited, int[][] graph) {
		for (int t = 0; t < graph.length; t++) {
			if (graph[i][t] != 0 && !visited[t]) {
				visited[t] = true;
				dfs(t, visited, graph);
			}
		}
	}
}
