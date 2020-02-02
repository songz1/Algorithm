/*
BFS 구현했어야함
*/

package Lotte;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int[][] sq = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < N; j++) {
				sq[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		int cnt = 0;
		int[] dong = new int[N * N / 2 + 2];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sq[i][j] != 0) {
					int r = i, l = j;
					dong[cnt]++;
					while (true) {
						sq[r][l] = 0;

						// 왼쪽칸 확인
						if (l != 0 && sq[r][l - 1] != 0) {
							dong[cnt]++;
							l = l - 1;
						}
						// 오른쪽칸 확인
						else if (l != N - 1 && sq[r][l + 1] != 0) {
							dong[cnt]++;
							l = l + 1;
						}
						// 위칸 확인
						else if (r != 0 && sq[r - 1][l] != 0) {
							dong[cnt]++;
							r = r - 1;
						}
						// 아래칸 확인
						else if (r != N - 1 && sq[r + 1][l] != 0) {
							dong[cnt]++;
							r = r + 1;
						} else {
							cnt++;
							break;
						}
					}
				}
			}
		}

		Arrays.sort(dong);

		System.out.println(cnt);
		for (int i = 0; i < dong.length; i++) {
			if (dong[i] != 0) {
				System.out.println(dong[i]);
			}
		}
	}
}
