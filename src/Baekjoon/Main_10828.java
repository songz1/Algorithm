/*
송지은_백준 알고리즘 10828번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828 {
	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[] stack = new int[n];
		int top = -1;
		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String str = stringTokenizer.nextToken();

			switch (str) {
				case "push":
					stack[++top] = Integer.parseInt(stringTokenizer.nextToken());
					break;
				case "pop":
					if (top < 0) {
						System.out.println(-1);
					} else {
						System.out.println(stack[top--]);
					}
					break;
				case "size":
					System.out.println(top + 1);
					break;
				case "empty":
					if (top < 0) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					break;
				case "top":
					if (top < 0) {
						System.out.println(-1);
					} else {
						System.out.println(stack[top]);
					}
					break;
			}
		}

	}
}
