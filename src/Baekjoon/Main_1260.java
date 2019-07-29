/*
송지은_백준 알고리즘 1260번
*/

package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int v = input.nextInt();

		int x, y;
		int[][] graph = new int[n][n];
		boolean[] visited = new boolean[n];

		for (int i = 0; i < m; i++) {
			x = input.nextInt();
			y = input.nextInt();

			graph[x - 1][y - 1] = 1;
			graph[y - 1][x - 1] = 1;
		}

		DFS(v - 1, graph, visited);
		System.out.println();

		Arrays.fill(visited, false);
		BFS(v - 1, graph, visited);
	}

	public static void DFS(int i, int[][] graph, boolean[] visited) {
		System.out.print((i + 1) + " ");
		visited[i] = true;

		for (int k = 0; k < graph.length; k++) {
			if (graph[i][k] != 0 && !visited[k]) {
				DFS(k, graph, visited);
			}
		}
	}

	public static void BFS(int i, int[][] graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		visited[i] = true;
		System.out.print((i + 1) + " ");

		int temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();

			for (int j = 0; j < graph.length; j++) {
				if (graph[temp][j] != 0 && !visited[j]) {
					queue.offer(j);
					visited[j] = true;
					System.out.print((j + 1) + " ");
				}
			}
		}
	}
}

