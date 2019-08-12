/*
송지은_백준 알고리즘 9095번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9095 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());

		int[] count = new int[12];
		count(count);

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(bufferedReader.readLine());
			System.out.println(count[n]);
		}
	}

	static void count(int[] count) {
		count[0] = 0;
		count[1] = 1;
		count[2] = 2;
		count[3] = 4;

		int i = 4;
		while (i <= 11) {
			count[i] = count[i - 1] + count[i - 2] + count[i - 3];
			i++;
		}
	}
}
