/*
송지은_백준 알고리즘 3015번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_3015_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		ArrayDeque<Integer> height = new ArrayDeque<>();
		ArrayDeque<Integer> people = new ArrayDeque<>();
		long result = 0L;
		for (int i = 0; i < n; i++) {
			int person = Integer.parseInt(bufferedReader.readLine());

			while (!height.isEmpty() && height.peek() < person) {
				height.pop();
				result += (long) people.pop();
			}

			if (height.isEmpty()) {
				height.push(person);
				people.push(1);
			} else if (!height.isEmpty() && height.peek() >= person) {
				if (height.peek() == person) {
					height.pop();
					int temp = people.pop();
					result += (long) temp;

					if (!height.isEmpty()) {
						result += 1L;
					}
					height.push(person);
					people.push(++temp);
				} else {
					height.push(person);
					people.push(1);
					result += 1L;
				}
			}
		}
		System.out.println(result);
	}
}
