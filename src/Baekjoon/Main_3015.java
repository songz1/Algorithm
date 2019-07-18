/*
송지은_백준 알고리즘 3015번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_3015 {
	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		long result = 0L;
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		ArrayDeque<Integer> people = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(bufferedReader.readLine());

			while (!deque.isEmpty() && deque.peek() < height) {
				result += (long) people.peek();
				deque.pop();
				people.pop();
			}

			if (!deque.isEmpty()) {
				if (deque.peek() == height) {
					int dequeTemp = deque.pop();
					int peopleTemp = people.pop();
					result += (long) peopleTemp;
					if (!deque.isEmpty()) {
						result += 1L;
					}
					peopleTemp++;
					deque.push(dequeTemp);
					people.push(peopleTemp);
				} else {
					deque.push(height);
					people.push(1);
					result += 1L;
				}
			} else {
				deque.push(height);
				people.push(1);
			}
		}

		System.out.println(result);
	}
}
