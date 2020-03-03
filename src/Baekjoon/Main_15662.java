/*
송지은_백준 알고리즘 15662번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_15662 {
	static ArrayDeque<Integer>[] wheel;
	static int[][] SN;
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bufferedReader.readLine());

		wheel = new ArrayDeque[T];
		SN = new int[T][3];
		for (int i = 0; i < T; i++) {
			wheel[i] = new ArrayDeque<>();
			String temp = bufferedReader.readLine();
			for (int j = 0; j < 8; j++) {
				int value = temp.charAt(j) - '0';
				wheel[i].addLast(value);

				if (j == 0) {
					SN[i][0] = value;
				} else if (j == 2) {
					SN[i][1] = value;
				} else if (j == 6) {
					SN[i][2] = value;
				}
			}
		}

		int K = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int num = Integer.parseInt(stringTokenizer.nextToken()) - 1;
			int direction = Integer.parseInt(stringTokenizer.nextToken());

			turn(num, direction);
			setSN();
		}

		int count = 0;
		for (int i = 0; i < T; i++) {
			if (SN[i][0] == 1) {
				count++;
			}
		}
		System.out.print(count);
	}

	public static void setSN() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		for (int k = 0; k < T; k++) {
			deque.clear();
			deque = wheel[k].clone();
			for (int j = 0; j < 8; j++) {
				int value = deque.removeFirst();
				if (j == 0) {
					SN[k][0] = value;
				} else if (j == 2) {
					SN[k][1] = value;
				} else if (j == 6) {
					SN[k][2] = value;
				}
			}
		}
	}

	public static void turn(int num, int direction) {
		if (direction == 1) {
			int temp = wheel[num].removeLast();
			wheel[num].addFirst(temp);
			check(num, -1);
		} else {
			int temp = wheel[num].removeFirst();
			wheel[num].addLast(temp);
			check(num, 1);
		}
	}

	public static void check(int num, int dir) {
		if (num == 0) {
			turn2(num, dir, 1);
		} else if (num == T - 1) {
			turn2(num, dir, -1);
		} else {
			turn2(num, dir, 1);
			turn2(num, dir, -1);
		}
	}

	public static void turn2(int num, int dir, int rl) {
		int temp;

		// 오른쪽
		if (rl == 1) {
			for (int i = num; i < T - 1; i++) {
				if (SN[i][1] == SN[i + 1][2]) {
					break;
				} else {
					if (dir == 1) {
						temp = wheel[i + 1].removeLast();
						wheel[i + 1].addFirst(temp);
						dir = -1;
					} else {
						temp = wheel[i + 1].removeFirst();
						wheel[i + 1].addLast(temp);
						dir = 1;
					}
				}
			}
		}
		// 왼쪽
		else {
			for (int i = num; i > 0; i--) {
				if (SN[i][2] == SN[i - 1][1]) {
					break;
				} else {
					if (dir == 1) {
						temp = wheel[i - 1].removeLast();
						wheel[i - 1].addFirst(temp);
						dir = -1;
					} else {
						temp = wheel[i - 1].removeFirst();
						wheel[i - 1].addLast(temp);
						dir = 1;
					}
				}
			}
		}
	}
}
