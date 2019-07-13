/*
송지은_백준 알고리즘 2504번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_2504_X {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();

		parenthesis(str);

	}

	static int parenthesis(String str) {
		int[] open_count = new int[2];
		int score = 0;
		int tempScore = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				open_count[0]++;

			} else if (str.charAt(i) == '[') {
				open_count[1]++;
			} else if (str.charAt(i) == ')') {
				if (open_count[0] == 0) {
					return 0;
				} else if (open_count[0] > 1 || open_count[1] > 1) {
					tempScore += 2;
					open_count[0]--;

				}
			}
		}
		return 0;
	}

}
