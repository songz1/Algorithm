/*
송지은_백준 알고리즘 11650번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11650 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[][] xy = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			xy[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			xy[i][1] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(xy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});

		for (int i = 0; i < n; i++) {
			System.out.println(xy[i][0] + " " + xy[i][1]);
		}
	}
}
