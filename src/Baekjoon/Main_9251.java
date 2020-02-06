/*
송지은_백준 알고리즘 9251번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String a = bufferedReader.readLine();
		String b = bufferedReader.readLine();

		int[][] lcs = new int[a.length() + 1][b.length() + 1];
		for (int i = 1; i < a.length() + 1; i++) {
			for (int j = 1; j < b.length() + 1; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		System.out.println(lcs[a.length()][b.length()]);
	}
}
