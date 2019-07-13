/*
송지은_백준 알고리즘 4949번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4949_X {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = input.readLine();
		int small = 0;
		int big = 0;
		boolean balance = true;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				if (!balance || small != 0 || big != 0) {
					System.out.println("no");
				} else {
					System.out.println("yes");
				}
				small = 0;
				big = 0;
				balance = true;
			} else if (str.charAt(i) == '(') {
				small++;
			} else if (str.charAt(i) == ')') {
				if (small <= 0) {
					balance = false;
				}
				small--;
			} else if (str.charAt(i) == '[') {
				big++;
			} else if (str.charAt(i) == ']') {
				if (big <= 0) {
					balance = false;
				}
				big--;
			}
		}
	}
}
