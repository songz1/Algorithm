/*
송지은_백준 알고리즘 10866번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10866_X {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		Deque deque = new Deque(n);
		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String order = stringTokenizer.nextToken();

			switch (order) {
				case "push_front":
					deque.push_front(Integer.parseInt(stringTokenizer.nextToken()));
					break;
				case "push_back":
					deque.push_back(Integer.parseInt(stringTokenizer.nextToken()));
					break;
				case "pop_front":
					System.out.println(deque.pop_front());
					break;
				case "pop_back":
					System.out.println(deque.pop_back());
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					System.out.println(deque.empty());
					break;
				case "front":
					System.out.println(deque.front());
					break;
				case "back":
					System.out.println(deque.back());
					break;
			}
		}
	}

	public static class Deque {
		int[] arr;
		int front = 1;
		int back = 1;
		int count = 0;

		public Deque(int size) {
			arr = new int[size];

		}

		public boolean isFull() {
			return arr.length == count;
		}

		public void push_front(int x) {
			if (isFull()) {
				return;
			}
			int frontIdx = (front - 1) % arr.length;
			arr[frontIdx] = x;
			front = frontIdx + 1;
			count++;
		}

		public void push_back(int x) {
			if (isFull()) {
				return;
			}
			int backIdx = (back) % arr.length;
			arr[backIdx] = x;
			back = backIdx + 1;
			count++;
		}

		public int pop_front() {
			if (count == 0) {
				return -1;
			}
			int temp = arr[front-1];
			front = (front + 1) % arr.length;
			count--;
			return temp;
		}

		public int pop_back() {
			if (count == 0) {
				return -1;
			}
			int temp = arr[back-1];
			back = (back - 1) % arr.length;
			count--;
			return temp;
		}

		public int size() {
			return count;
		}

		public int empty() {
			return count == 0 ? 1 : 0;
		}

		public int front() {
			if (count == 0) {
				return -1;
			}
			return arr[front];
		}

		public int back() {
			if (count == 0) {
				return -1;
			}
			return arr[back];
		}
	}
}
