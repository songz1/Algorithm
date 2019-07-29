/*
송지은_백준 알고리즘 6603번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_6603 {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		Scanner input = new Scanner(System.in);
		int k;

		while ((k = input.nextInt()) != 0) {
			int[] s = new int[k];
			int[] result = new int[6];
			for (int i = 0; i < k; i++) {
				s[i] = input.nextInt();
			}

			dfs(0, 0, s, result, stringBuilder);
			stringBuilder.append("\n");
		}

		System.out.print(stringBuilder.toString());
	}

	static void dfs(int i, int count, int[] s, int[] result, StringBuilder stringBuilder) {
		if (count == 6) {
			for (int j = 0; j < result.length; j++) {
				stringBuilder.append(result[j] + " ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int j = i; j < s.length; j++) {
			result[count] = s[j];
			dfs(j + 1, count + 1, s, result, stringBuilder);
		}
	}
}
