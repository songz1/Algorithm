/*
송지은_백준 알고리즘 2108번
*/

package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_2108 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);

		System.out.println((int) Math.round(sum * 1.0 / n));
		System.out.println(arr[n / 2]);

		int[] count = new int[8001];
		for (int i : arr) {
			count[i + 4000]++;
		}
		int max = 1;
		ArrayList<Integer> maxValues = new ArrayList<>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				maxValues.clear();
				maxValues.add(i - 4000);
				max = count[i];
			} else if (count[i] == max) {
				maxValues.add(i - 4000);
			}
		}
		Collections.sort(maxValues);

		System.out.println(maxValues.size() == 1 ? maxValues.get(0) : maxValues.get(1));
		System.out.println(arr[n - 1] - arr[0]);
	}
}
