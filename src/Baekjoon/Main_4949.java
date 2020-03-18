/*
송지은_백준 알고리즘 4949번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main_4949 {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String str = input.readLine();
			if (str.equals(".")) {
				break;
			}

			boolean balance = true;
			ArrayDeque<Character> deque = new ArrayDeque<>();
			for (char c : str.toCharArray()) {
				switch (c) {
					case '(':
						deque.push('(');
						break;
					case ')':
						if (!deque.isEmpty() && deque.peek() == '(') {
							deque.pop();
						} else {
							balance = false;
						}
						break;
					case '[':
						deque.push('[');
						break;
					case ']':
						if (!deque.isEmpty() && deque.peek() == '[') {
							deque.pop();
						} else {
							balance = false;
						}
						break;
				}
			}

			bufferedWriter.write(balance && deque.isEmpty() ? "yes\n" : "no\n");
			bufferedWriter.flush();
//			System.out.println(balance && deque.isEmpty() ? "yes" : "no");
		}
		bufferedWriter.close();
	}
}
