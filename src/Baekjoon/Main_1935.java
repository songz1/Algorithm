/*
송지은_백준 알고리즘 1935번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_1935 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		String str = bufferedReader.readLine();

		int[] abc = new int[26];
		for (int i = 0; i < n; i++) {
			abc[i] = Integer.parseInt(bufferedReader.readLine());
		}

		ArrayDeque<Double> deque = new ArrayDeque<>();
		double front;
		double back;
		for (char c : str.toCharArray()) {
			if (65 <= (int) c && (int) c <= 90) {
				deque.push((double) (abc[(int) c - 65]));
			} else if (c == '+') {
				back = deque.pop();
				front = deque.pop();
				deque.push(front + back);
			} else if (c == '-') {
				back = deque.pop();
				front = deque.pop();
				deque.push(front - back);
			} else if (c == '*') {
				back = deque.pop();
				front = deque.pop();
				deque.push(front * back);
			} else if (c == '/') {
				back = deque.pop();
				front = deque.pop();
				deque.push(front / back);
			}
		}

		System.out.printf("%.2f", deque.pop());
	}
}
