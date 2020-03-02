/*
송지은_백준 알고리즘 16926번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_16926 {
	static int R;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		R = Integer.parseInt(stringTokenizer.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		int[][] result = new int[N][M];
		for (int i = 0; i <= N - 1 - i && i <= M - 1 - i; i++) {
			turn(arr, result, i, i, N - i - 1, M - i - 1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] turn(int[][] arr, int[][] result, int xmin, int ymin, int xmax, int ymax) {
		int x = xmin, y = ymin;
		ArrayDeque<Integer> temp = new ArrayDeque<>();

		while (y <= ymax) {
			temp.addLast(arr[x][y]);
			y++;
		}
		y--;
		x++;
		while (x <= xmax) {
			temp.addLast(arr[x][y]);
			x++;
		}
		x--;
		y--;
		while (y >= ymin) {
			temp.addLast(arr[x][y]);
			y--;
		}
		y++;
		x--;
		while (x > xmin) {
			temp.addLast(arr[x][y]);
			x--;
		}

		for (int i = 0; i < R; i++) {
			int num = temp.removeFirst();
			temp.addLast(num);
		}

		x = xmin;
		y = ymin;

		while (y <= ymax) {
			result[x][y] = temp.removeFirst();
			y++;
		}
		y--;
		x++;
		while (x <= xmax) {
			result[x][y] = temp.removeFirst();
			x++;
		}
		x--;
		y--;
		while (y >= ymin) {
			result[x][y] = temp.removeFirst();
			y--;
		}
		y++;
		x--;
		while (x > xmin) {
			result[x][y] = temp.removeFirst();
			x--;
		}

		return result;
	}
}


