/*
송지은_해시 테이블_Person
*/

package Study_06;

import java.util.Objects;

public class Main_28 {
	public static void main(String[] args) throws Exception {
		Person[] a = new Person[]{new Person("홍길동", 18), new Person("임꺽정", 22), new Person("전우치", 23)};
		HashTable hashTable = new HashTable();
		for (Person person : a) {
			hashTable.add(person);
		}
		for (Person person : a) {
			System.out.println(hashTable.contains(person));
		}
		System.out.println(hashTable.contains(new Person("연흥부", 30)));
	}

	static class Person {
		String name;
		int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}

		@Override
		public boolean equals(Object object) {
			if (object instanceof Person) {
				Person person = (Person) object;
				return Objects.equals(this.name, person.name) && this.age == person.age;
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, age);
		}
	}

	static class HashTable{
		static final Object EMPTY = null;
		static final Object DELETED = new Object();
		static final double A = 0.3758;
		static final int[] PRIME_NUMBER = {3, 5, 7, 11, 13, 17, 19};

		Object[] objects;
		int count;
		int threshold;

		public HashTable() {
			this(32);
		}

		public HashTable(int size) {
			this.objects = new Object[size];
			this.threshold = (int) (this.objects.length * 0.7);
		}

		private void resize() {
			int newSize = objects.length * 2;
			HashTable newHashTable = new HashTable(newSize);
			for (Object value : objects) {
				if (value != EMPTY && value != DELETED) {
					newHashTable.add(value);
				}
			}
			this.objects = newHashTable.objects;
			this.threshold = newHashTable.threshold;
		}

		private int getIndex(Object value, int collisionCount) {
			int startIndex = (int) (((value.hashCode() * A) % 1) * this.objects.length);
			int step = PRIME_NUMBER[value.hashCode() % 7];
			return (startIndex + collisionCount * step) % objects.length;
		}

		public void add(Object value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (objects[index] == EMPTY || objects[index] == DELETED) {
					objects[index] = value;
					this.count++;
					if (this.count >= this.threshold) {
						resize();
					}
					return;
				} else if (objects[index] == value) {
					return;
				}
				++collisionCount;
			} while (collisionCount < objects.length);
		}

		public void remove(Object value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (objects[index] == EMPTY) {
					return;
				} else if (objects[index] == value) {
					objects[index] = DELETED;
					this.count--;
					return;
				}
				++collisionCount;
			} while (collisionCount < objects.length);
		}

		public boolean contains(Object value) {
			int collisionCount = 0;
			do {
				int index = getIndex(value, collisionCount);
				if (objects[index] == EMPTY) {
					return false;
				} else if (objects[index] == value) {
					return true;
				}
				++collisionCount;
			} while (collisionCount < objects.length);
			return false;
		}
	}
}
