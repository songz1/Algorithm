/*
송지은_백준 알고리즘 1966번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine());
		int temp;

		for (int i = 0; i < t; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int n = Integer.parseInt(stringTokenizer.nextToken());
			int m = Integer.parseInt(stringTokenizer.nextToken());

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			Queue<Integer> q = new LinkedList<>();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				temp = Integer.parseInt(stringTokenizer.nextToken());
				((LinkedList<Integer>) q).addLast(temp);
				arr[j] = temp;
			}

			Arrays.sort(arr);
			int index = n - 1;

			int count = 0;
			while (m >= 0) {
				if (((LinkedList<Integer>) q).getFirst() == arr[index]) {
					((LinkedList<Integer>) q).removeFirst();
					index--;
					count++;
					m--;
				} else if (m != 0 && ((LinkedList<Integer>) q).getFirst() != arr[index]) {
					temp = ((LinkedList<Integer>) q).getFirst();
					((LinkedList<Integer>) q).removeFirst();
					((LinkedList<Integer>) q).addLast(temp);
					m--;
				} else if (m == 0 && ((LinkedList<Integer>) q).getFirst() != arr[index]) {
					temp = ((LinkedList<Integer>) q).getFirst();
					((LinkedList<Integer>) q).removeFirst();
					((LinkedList<Integer>) q).addLast(temp);
					m = index;
				}
			}

			System.out.println(count);
		}
	}
}
