/*
송지은_양방향 원형 큐
 */

package SummerClass;

public class CircularQueue {
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

	public void addFirst(int value) throws Exception {
		if (isFull()) {
			throw new Exception("Full");
		}
		front = (front - 1) % a.length;
		a[front] = value;
		count++;
	}

	public int removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty");
		}
		int value = a[front];
		front = (front + 1) % a.length;
		count--;
		return value;
	}

	public void addLast(int value) throws Exception {
		if (isFull()) {
			throw new Exception("Full");
		}
		a[end] = value;
		end = (end + 1) % a.length;
		count++;
	}

	public int removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty");
		}
		end = (end - 1) % a.length;
		int value = a[end];
		count--;
		return value;
	}
}
