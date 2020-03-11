/*
송지은_백준 알고리즘 1939번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1939 {
	static int max = Integer.MIN_VALUE;
	static ArrayList<Node>[] lists;
	static Boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());  // 섬 개수
		int M = Integer.parseInt(stringTokenizer.nextToken());  // 다리 개수
		lists = new ArrayList[N + 1];
		visited = new Boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			lists[i] = new ArrayList<>();
		}

		int A, B, C, max = 0;
		for (int i = 0; i < M; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			A = Integer.parseInt(stringTokenizer.nextToken());
			B = Integer.parseInt(stringTokenizer.nextToken());
			C = Integer.parseInt(stringTokenizer.nextToken());

			lists[A].add(new Node(B, C));
			lists[B].add(new Node(A, C));

			max = Math.max(max, C);
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int start = Integer.parseInt(stringTokenizer.nextToken());
		int end = Integer.parseInt(stringTokenizer.nextToken());

		int left = 1;
		int right = max;
		int result = 0;

		// 이분 탐색
		while (left <= right) {
			Arrays.fill(visited, false);

			int mid = (left + right) / 2;

			if (DFS(start, end, mid)) {
				result = result >= mid ? result : mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.print(result);
	}

	// weight 무게로 목적지 도달 가능한지 확인
	public static Boolean DFS(int start, int end, int weight) {
		if (visited[start]) {
			return false;
		}

		if (start == end) {
			return true;
		}

		visited[start] = true;

		for (int i = 0; i < lists[start].size(); i++) {
			if (lists[start].get(i).weight >= weight) {
				if(DFS(lists[start].get(i).num, end, weight)){
					return true;
				}
			}
		}

		return false;
	}

	public static class Node {
		int num;
		int weight;

		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
}
