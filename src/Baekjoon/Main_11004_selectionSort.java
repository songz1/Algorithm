/*
송지은_백준 알고리즘 11004번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_11004_selectionSort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = input.nextInt();
		}

		System.out.println(selection(a, 0, a.length - 1, k));
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) {
		swap(a, end, (start + end) / 2);
		int pivot = end;
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (a[j] < a[pivot]) {
				swap(a, ++i, j);
			}
		}
		swap(a, ++i, pivot);

		return i;
	}

	static int selection(int[] a, int start, int end, int nth) {
		if (start >= end) {
			return a[start];
		}

		int middle = partition(a, start, end);
		int middle_nth = middle - start + 1;

		if (middle_nth == nth) {
			return a[middle];
		} else if (middle_nth > nth) {
			return selection(a, start, middle - 1, nth);
		} else {
			return selection(a, middle + 1, end, nth - middle_nth);
		}
	}
}
