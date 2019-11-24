/*
송지은_백준 알고리즘 11279번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11279 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>(new ComparatorDescending());

		int data;
		int n = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			data = Integer.parseInt(bufferedReader.readLine());

			if (data == 0) {
				if (queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.offer(data);
			}
		}
	}
}

class ComparatorDescending implements Comparator<Integer> {
	@Override
	public int compare(Integer n1, Integer n2) {
		if (n1 < n2) {
			return 1;
		} else {
			return -1;
		}
	}
}


