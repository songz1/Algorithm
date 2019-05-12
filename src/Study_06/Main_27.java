/*
송지은_해시 테이블_multiplication method + double hashing + 자동 크기 확장 기능
*/

package Study_06;

import java.util.Random;

public class Main_27 {
	static class HashTable {
		static final int EMPTY = 0;
		static final int DELETED = -1;
		static final double A = 0.3758;
		static final int[] PRIME_NUMBER = {3, 5, 7, 11, 13, 17, 19};
		int[] a;
		int count;
		int threshold;

		public HashTable() {
			this(32);
		}

		public HashTable(int size) {
			this.a = new int[size];
			this.threshold = (int) (this.a.length * 0.7);
		}

		private void resize() {
			int newSize = a.length * 2;
			HashTable newHashTable = new HashTable(newSize);
			for (int value : a) {
				if (value != EMPTY && value != DELETED) {
					newHashTable.add(value);
				}
			}
			this.a = newHashTable.a;
			this.threshold = newHashTable.threshold;
		}

		public void add(int value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (a[index] == EMPTY || a[index] == DELETED) {
					a[index] = value;
					this.count++;
					if (this.count >= this.threshold) {
						resize();
					}
					return;
				} else if (a[index] == value) {
					return;
				}
				++collisionCount;
			} while (collisionCount < a.length);
		}

		private int getIndex(int value, int collisionCount) {
			int startIndex = (int) (((value * A) % 1) * this.a.length);
			int step = PRIME_NUMBER[value % 7];
			return (startIndex + collisionCount * step) % a.length;
		}

		public void remove(int value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (a[index] == EMPTY) {
					return;
				} else if (a[index] == value) {
					a[index] = DELETED;
					this.count--;
					return;
				}
				++collisionCount;
			} while (collisionCount < a.length);
		}

		public boolean contains(int value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (a[index] == EMPTY) {
					return false;
				} else if (a[index] == value) {
					return true;
				}
				++collisionCount;
			} while (collisionCount < a.length);
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		int maxValue = 600;
		HashTable hashTable = new HashTable();
		Random random = new Random();
		for (int i = 0; i < maxValue * 2; ++i) {
			hashTable.add(random.nextInt(maxValue));
		}
		for (int i = 1; i <= maxValue; ++i) {
			if (hashTable.contains(i)) {
				System.out.println(i);
			}
		}
	}
}


