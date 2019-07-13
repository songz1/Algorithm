/*
송지은_백준 알고리즘 3015번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3015_X {
	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[] line = new int[n];
		for (int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(bufferedReader.readLine());
		}

		Stack stack = new Stack();
		for (int i = 0; i < n; i++) {
			if (stack.isEmpty()) {
				stack.push(line[i]);
			} else {


			}
		}
	}
}
