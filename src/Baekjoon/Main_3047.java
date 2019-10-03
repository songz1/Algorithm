/*
송지은_백준 알고리즘 3047번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_3047 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		String abc = scanner.next();

		int temp;
		if (A > B) {
			temp = B;
			B = A;
			A = temp;
		}
		if (C < A) {
			temp = C;
			C = B;
			B = A;
			A = temp;
		} else if (C < B) {
			temp = C;
			C = B;
			B = temp;
		}

		for (char c : abc.toCharArray()) {
			if (c == 'A') {
				System.out.print(A + " ");
			} else if (c == 'B') {
				System.out.print(B + " ");
			} else if (c == 'C') {
				System.out.print(C + " ");
			}
		}
	}
}
