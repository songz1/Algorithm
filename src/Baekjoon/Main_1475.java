/*
송지은_백준 알고리즘 1475번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1475 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String room = scanner.next();
		int[] num = new int[9];
		int temp;

		for (char ch : room.toCharArray()) {
			temp = ch - '0';
			if (temp == 9) {
				num[6]++;
			} else {
				num[temp]++;
			}
		}

		if (num[6] % 2 == 0) {
			num[6] = num[6] / 2;
		} else {
			num[6] = (num[6] / 2) + 1;
		}

		int max = 0;
		for (int i = 0; i < num.length; i++) {
			max = max > num[i] ? max : num[i];
		}

		System.out.print(max);
	}
}
