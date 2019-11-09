/*
송지은_백준 알고리즘 2164번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2164 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		Queue queue = new Queue(n);
		queue.setQueue();

		while (queue.getSize() != 1) {
			queue.dequeue();
			if (queue.getSize() == 1) {
				break;
			}

			int temp = queue.getValue();
			queue.dequeue();
			queue.enqueue(temp);
		}

		queue.print();
	}

	static class Queue {
		int max;
		int size;
		int front, rear;
		int[] queue;

		public Queue(int n) {
			max = n;
			front = rear = size = 0;
			queue = new int[max];
		}

		void setQueue() {
			for (int i = 0; i < max; i++) {
				queue[i] = i + 1;
			}

			front = 0;
			rear = max - 1;
			size = max;
		}

		int getSize() {
			return size;
		}

		void print() {
			System.out.print(queue[front]);
		}

		int getValue() {
			return queue[front];
		}

		boolean isEmpty() {
			return size == 0;
		}

		boolean isFull() {
			return size == max;
		}

		void enqueue(int data) {
			if (isFull()) {
				return;
			}

			rear = (++rear) % max;
			queue[rear] = data;
			size++;
		}

		void dequeue() {
			if (isEmpty()) {
				return;
			}

			front = (++front) % max;
			size--;
		}
	}
}
