/*
송지은_백준 알고리즘 7469번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7469 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n, m;
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		int[] a = new int[n];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int i, j, k;
		while (m-- > 0) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			i = Integer.parseInt(stringTokenizer.nextToken());
			j = Integer.parseInt(stringTokenizer.nextToken());
			k = Integer.parseInt(stringTokenizer.nextToken());

			System.out.println(Q(a, i, j, k));
		}
	}

	public static int Q(int[] a, int i, int j, int k) {
		int[] temp = new int[j - i + 1];
		int count = 0;
		for (int c = i - 1; c < j; c++) {
			temp[count++] = a[c];
		}

		Arrays.sort(temp);

		return temp[k - 1];
	}
}
