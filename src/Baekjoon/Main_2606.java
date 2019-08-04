/*
송지은_백준 알고리즘 2606번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int E = Integer.parseInt(bufferedReader.readLine());

		int[][] graph = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < E; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int V1 = Integer.parseInt(stringTokenizer.nextToken());
			int V2 = Integer.parseInt(stringTokenizer.nextToken());

			graph[V1][V2] = 1;
			graph[V2][V1] = 1;
		}

		DFS(1, graph, visited);

		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				count++;
			}
		}

		System.out.print(count - 1);
	}

	static void DFS(int V, int[][] graph, boolean[] visited) {
		visited[V] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[V][i] != 0 && !visited[i]) {
				DFS(i, graph, visited);
			}
		}
	}
}
