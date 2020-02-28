/*
송지은_백준 알고리즘 2164번
*/

package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			((LinkedList<Integer>) queue).removeFirst();
			int temp = ((LinkedList<Integer>) queue).removeFirst();
			((LinkedList<Integer>) queue).addLast(temp);
		}

		System.out.print(queue.poll());
	}
}
