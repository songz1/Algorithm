/*
송지은_백준 알고리즘 3985번

cake 배열에 순서대로 사람 번호 저장, minus 배열에 원하는 조각 개수 저장
-> minus 배열 돌면서 원한 개수 최대인 사람 구하기
-> cake 배열 돌면서 실제 받은 개수 minus 배열에 저장 >> minus 배열 재사용
-> minus 배열 돌면서 실제 받은 개수 최대인 사람 구하기
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3985 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(bufferedReader.readLine());
		int N = Integer.parseInt(bufferedReader.readLine());

		int a, b;
		int[] minus = new int[N + 1];
		int[] cake = new int[L + 1];

		StringTokenizer stringTokenizer;
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			a = Integer.parseInt(stringTokenizer.nextToken());
			b = Integer.parseInt(stringTokenizer.nextToken());
			minus[i] = b - a;

			for (int j = a; j <= b; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
				}
			}
		}

		int maxTemp = minus[1];
		int maxBefore = 1;
		for (int i = 2; i <= N; i++) {
			if (maxTemp < minus[i]) {
				maxTemp = minus[i];
				maxBefore = i;
			}
		}

		Arrays.fill(minus, 0);
		for (int i = 1; i <= L; i++) {
			if (cake[i] != 0) {
				minus[cake[i]] += 1;
			}
		}

		maxTemp = minus[1];
		int maxAfter = 1;
		for (int i = 2; i <= N; i++) {
			if (maxTemp < minus[i]) {
				maxTemp = minus[i];
				maxAfter = i;
			}
		}

		System.out.println(maxBefore);
		System.out.print(maxAfter);
	}
}
