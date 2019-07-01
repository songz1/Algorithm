/*
송지은_백준 알고리즘 1874번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1874 {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder pm = new StringBuilder();
		int n = Integer.parseInt(input.readLine());

		int top = -1;
		int[] stack = new int[n];
		int num, max = 0;

		while (n-- > 0) {
			num = Integer.parseInt(input.readLine());
			if (top < 0) {
				for (int i = max + 1; i <= num; i++) {
					stack[++top] = i;
					pm.append('+');
				}
				pm.append('-');
				top--;
				max = num;
			} else {
				if (stack[top] > num) {
					System.out.println("NO");
					input.close();
					return;
				} else if (stack[top] == num) {
					pm.append('-');
					top--;
				} else {
					for (int i = max + 1; i <= num; i++) {
						stack[++top] = i;
						pm.append('+');
					}
					pm.append('-');
					top--;
					max = num;
				}
			}
		}

		for (int i = 0; i < pm.length(); i++) {
			System.out.println(pm.charAt(i));
		}

		input.close();
		return;
	}
}
