/*
송지은_백준 알고리즘 1918번
*/

package Baekjoon;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main_1918 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		ArrayDeque<Character> deque = new ArrayDeque<>();
		StringBuilder result = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (c == '*' || c == '/' || c == '+' || c == '-') {
				while (!deque.isEmpty() && (priority(deque.peek()) >= priority(c))) {
					result.append(deque.pop());
				}
				deque.push(c);
			} else if (c == '(') {
				deque.push(c);
			} else if (c == ')') {
				while (!deque.isEmpty() && deque.peek() != '(') {
					result.append(deque.pop());
				}
				deque.pop();
			} else {
				result.append(c);
			}
		}

		while (!deque.isEmpty()) {
			result.append(deque.pop());
		}

		System.out.println(result.toString());
	}

	public static int priority(char c) {
		if (c == '*' || c == '/') {
			return 2;
		} else if (c == '+' || c == '-') {
			return 1;
		} else {
			return 0;
		}
	}
}
