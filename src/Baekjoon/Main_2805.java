/*
송지은_백준 알고리즘 2805번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		int[] tree = new int[N];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(tree);

		int min = 0;
		int max = tree[N - 1];
		while (min <= max) {
			int mid = (min + max) / 2;
			long getTree = 0;

			for (int t : tree) {
				getTree += (t - mid > 0 ? t - mid : 0);
			}

			if (getTree >= M) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}

		System.out.print(max);
	}
}
