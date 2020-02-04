/*
송지은_백준 알고리즘 10866번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10866 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		Deque deque = new Deque();
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

	public static class DequeNode {
		int data;
		DequeNode rlink;
		DequeNode llink;

		public DequeNode(int data) {
			this.data = data;
			this.rlink = null;
			this.llink = null;
		}
	}

	public static class Deque {
		DequeNode front;
		DequeNode end;
		int count;

		public Deque() {
			front = null;
			end = null;
			count = 0;
		}

		public void push_front(int x) {
			DequeNode node = new DequeNode(x);

			if (empty() == 1) {
				front = node;
				end = node;
				node.rlink = null;
				node.llink = null;
			} else {
				node.rlink = front;
				node.llink = null;
				front.llink = node;
				front = node;
			}
			count++;
		}

		public void push_back(int x) {
			DequeNode node = new DequeNode(x);

			if (empty() == 1) {
				front = node;
				end = node;
				node.rlink = null;
				node.llink = null;
			} else {
				node.rlink = null;
				node.llink = end;
				end.rlink = node;
				end = node;
			}
			count++;
		}

		public int pop_front() {
			if (empty() == 1) {
				return -1;
			} else {
				int temp = front.data;
				if (front.rlink == null) {
					front = null;
					end = null;
				} else {
					front = front.rlink;
					front.llink = null;
				}
				count--;
				return temp;
			}
		}

		public int pop_back() {
			if (empty() == 1) {
				return -1;
			} else {
				int temp = end.data;
				if (end.llink == null) {
					front = null;
					end = null;
				} else {
					end = end.llink;
					end.rlink = null;
				}
				count--;
				return temp;
			}
		}

		public int size() {
			return count;
		}

		public int empty() {
			return (front == null ? 1 : 0);
		}

		public int front() {
			if (empty() == 1) {
				return -1;
			} else {
				return front.data;
			}
		}

		public int back() {
			if (empty() == 1) {
				return -1;
			} else {
				return end.data;
			}
		}
	}
}
