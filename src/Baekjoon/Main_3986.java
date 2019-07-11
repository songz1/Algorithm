/*
송지은_백준 알고리즘 3986번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3986 {
	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int goodWord = 0;
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			String word = bufferedReader.readLine();

			for (char c : word.toCharArray()) {
				if (stack.isEmpty() || stack.peek() != c) {
					stack.push(c);
				} else if (!stack.isEmpty() && stack.peek() == c) {
					stack.pop();
				}
			}
			if (stack.isEmpty()) {
				goodWord++;
			}
		}
		System.out.println(goodWord);
	}
}
