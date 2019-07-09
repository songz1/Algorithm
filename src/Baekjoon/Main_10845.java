/*
송지은_백준 알고리즘 10845번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10845 {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		CircularQueue circularQueue = new CircularQueue(n);

		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
			String order = stringTokenizer.nextToken();

			switch (order) {
				case "push":
					circularQueue.push(Integer.parseInt(stringTokenizer.nextToken()));
					break;
				case "pop":
					System.out.println(circularQueue.pop());
					break;
				case "size":
					System.out.println(circularQueue.count());
					break;
				case "empty":
					System.out.println((circularQueue.isEmpty() ? 1 : 0));
					break;
				case "front":
					System.out.println(circularQueue.getFront());
					break;
				case "back":
					System.out.println(circularQueue.getEnd());
					break;
			}
		}
	}

	public static class CircularQueue {
		int[] a;
		int front = 0, end = 0, count = 0;

		public CircularQueue(int size) {
			a = new int[size];
		}

		public boolean isFull() {
			return count == a.length;
		}

		public boolean isEmpty() {
			return count == 0;
		}

		public int count() {
			return count;
		}

		public int getFront() {
			if (isEmpty()) {
				return -1;
			}
			return a[front];
		}

		public int getEnd() {
			if (isEmpty()) {
				return -1;
			}
			return a[end - 1];
		}

		public int pop() {
			if (isEmpty()) {
				return -1;
			}
			int value = a[front];
			front++;
			if (front == a.length) {
				front = 0;
			}
			count--;
			return value;
		}

		public void push(int value) throws Exception {
			if (isFull()) {
				throw new Exception("Full");
			}
			a[end] = value;
			end++;
			if (end == a.length) {
				end = 0;
			}
			count++;
		}
	}
}
