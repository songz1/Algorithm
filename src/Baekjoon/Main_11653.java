/*
송지은_백준 알고리즘 11653번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_11653 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				System.out.println(i);
				n = n / i;
			}
		}
	}
}
