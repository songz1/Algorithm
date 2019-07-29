/*
송지은_백준 알고리즘 11724번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_11724 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		boolean[] visited = new boolean[n];
		int[][] graph = new int[n][n];
		int u, v;
		for (int i = 0; i < m; i++) {
			u = input.nextInt();
			v = input.nextInt();

			graph[u-1][v-1] = 1;
			graph[v-1][u-1] = 1;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, visited, graph);
				count++;
			}
		}

		System.out.println(count);
	}

	static void dfs(int i, boolean[] visited, int[][] graph) {
		visited[i] = true;
		for (int t = 0; t < graph.length; t++) {
			if (graph[i][t] != 0 && !visited[t]) {
				dfs(t, visited, graph);
			}
		}
	}
}
