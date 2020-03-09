/*
송지은_백준 알고리즘 17471번

배열에 데이터 입력
-> 1, 0 조합 구하기  >> 조합 어떻게 구하지.. 재귀?
-> 1, 0 각각 탐색해서 그룹 수 세기  >> DFS 탐색
-> 두 그룹이면 인원수 차이 구해서 최솟값 갱신  >> 인원수 저장해놓은 배열 필요
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471 {
	static int N;
	static int[] people;  // 인구 수
	static int[][] connection;  // 연결된 지역들 1, 연결 안된 지역들 0
	static Boolean[] visited;  // 방문 표시
	static int[] area;  // 지역 조합 구하기 용도
	static int min = Integer.MAX_VALUE;
	static Boolean check = false;  // 두 그룹으로 나눌 수 있는지 확인하는 변수

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		people = new int[N + 1];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int cnt, c;
		connection = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			cnt = Integer.parseInt(stringTokenizer.nextToken());
			for (int j = 1; j <= cnt; j++) {
				c = Integer.parseInt(stringTokenizer.nextToken());
				connection[i][c] = 1;
			}
		}

		area = new int[N];
		visited = new Boolean[N + 1];
		division(0);

		if (check) {
			System.out.print(min);
		} else {
			System.out.print(-1);
		}
	}

	// 조합 구하기
	public static void division(int a) {
		if (a == N) {
			Arrays.fill(visited, false);

			// 그룹 수 세기
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					DFS(i, area[i - 1]);
					count++;
				}
			}

			// 두 그룹인 경우
			if (count == 2) {
				check = true;

				// 각각 인원수 구하기
				int group1 = 0, group2 = 0;
				for (int i = 0; i < N; i++) {
					if (area[i] == 0) {
						group1 += people[i + 1];
					} else {
						group2 += people[i + 1];
					}
				}

				// min 갱신
				min = min < Math.abs(group1 - group2) ? min : Math.abs(group1 - group2);
			}

			return;
		}

		area[a] = 0;
		division(a + 1);

		area[a] = 1;
		division(a + 1);
	}

	// 탐색
	public static void DFS(int start, int a) {
		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && area[i - 1] == a && connection[start][i] == 1) {
				DFS(i, a);
			}
		}
	}
}
