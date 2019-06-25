/*
송지은_백준 알고리즘 2751번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_2751 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		mergeSort(arr, 0, arr.length - 1);

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	static void mergeSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int middle = (start + end) / 2;
		mergeSort(arr, start, middle);
		mergeSort(arr, middle + 1, end);
		merge(arr, start, middle, end);
	}

	static void merge(int[] arr, int start, int middle, int end) {
		int startIdx = start;
		int endIdx = middle + 1;
		int[] temp = new int[end - start + 1];
		int tempIdx = 0;

		while (startIdx <= middle && endIdx <= end) {
			if (arr[startIdx] > arr[endIdx]) {
				temp[tempIdx++] = arr[endIdx++];
			} else {
				temp[tempIdx++] = arr[startIdx++];
			}
		}
		while (startIdx <= middle) {
			temp[tempIdx++] = arr[startIdx++];
		}
		while (endIdx <= end) {
			temp[tempIdx++] = arr[endIdx++];
		}

		for (int i = 0; i < temp.length; i++) {
			arr[start + i] = temp[i];
		}
	}
}
