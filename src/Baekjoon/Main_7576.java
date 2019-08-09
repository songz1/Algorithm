/*
송지은_백준 알고리즘 7576번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		int N = Integer.parseInt(stringTokenizer.nextToken());

		int[][] graph = new int[N][M];
		int max = 0;

		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		BFS(N, M, graph);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					System.out.print(-1);
					return;
				}
				if (graph[i][j] > max) {
					max = graph[i][j];
				}
			}
		}

		System.out.print(max - 1);
	}

	public static void BFS(int N, int M, int[][] graph) {
		Queue<XY> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 1) {
					queue.offer(new XY(i, j));
				}
			}
		}

		XY temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			int x, y;

			// up
			if (temp.x - 1 >= 0 && graph[temp.x - 1][temp.y] == 0) {
				x = temp.up();
				y = temp.y;

				graph[x][y] = graph[temp.x][temp.y] + 1;
				queue.offer(new XY(x, y));
			}

			// down
			if (temp.x + 1 < N && graph[temp.x + 1][temp.y] == 0) {
				x = temp.down();
				y = temp.y;

				graph[x][y] = graph[temp.x][temp.y] + 1;
				queue.offer(new XY(x, y));
			}

			// left
			if (temp.y - 1 >= 0 && graph[temp.x][temp.y - 1] == 0) {
				x = temp.x;
				y = temp.left();

				graph[x][y] = graph[temp.x][temp.y] + 1;
				queue.offer(new XY(x, y));
			}

			// right
			if (temp.y + 1 < M && graph[temp.x][temp.y + 1] == 0) {
				x = temp.x;
				y = temp.right();

				graph[x][y] = graph[temp.x][temp.y] + 1;
				queue.offer(new XY(x, y));
			}
		}

	}

	static class XY {
		int x;
		int y;

		XY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int up() {
			int x = this.x - 1;
			return x;
		}

		int down() {
			int x = this.x + 1;
			return x;
		}

		int left() {
			int y = this.y - 1;
			return y;
		}

		int right() {
			int y = this.y + 1;
			return y;
		}
	}
}
