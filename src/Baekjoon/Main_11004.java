/*
송지은_백준 알고리즘 11004번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11004 {
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(input.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		st = new StringTokenizer(input.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(a, 0, n - 1);

		System.out.println(a[k - 1]);
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void mergeSort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}

		int middle = (start + end) / 2;
		mergeSort(a, start, middle);
		mergeSort(a, middle + 1, end);
		merge(a, start, middle, end);
	}

	static void merge(int[] a, int start, int middle, int end) {
		int startIdx = start;
		int endIdx = middle + 1;
		int[] temp = new int[end - start + 1];
		int tempIdx = 0;

		while (startIdx <= middle && endIdx <= end) {
			if (a[startIdx] < a[endIdx]) {
				temp[tempIdx++] = a[startIdx++];
			} else {
				temp[tempIdx++] = a[endIdx++];
			}
		}
		while (startIdx <= middle) {
			temp[tempIdx++] = a[startIdx++];
		}
		while (endIdx <= end) {
			temp[tempIdx++] = a[endIdx++];
		}

		for (int i = 0; i < temp.length; i++) {
			a[start + i] = temp[i];
		}
	}
}
