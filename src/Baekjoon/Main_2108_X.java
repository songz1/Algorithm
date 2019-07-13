/*
송지은_백준 알고리즘 2108번
*/

package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2108_X {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		System.out.println(sum / n);
		System.out.println(arr[n / 2]);

		int[] countP = new int[4001];
		int[] countM = new int[4001];
		int modeIdxP = 0;
		int modeIdxM = 0;
		int modeCount = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] >= 0) {
				countP[arr[i]]++;
				if (countP[modeIdxP] < countP[arr[i]]) {
					modeIdxP = arr[i];
				}
			} else {
				countM[arr[i] * -1]++;
				if (countM[modeIdxM] < countM[arr[i] * -1]) {
					modeIdxM = arr[i] * -1;
				}
			}
			modeCount = countP[modeIdxP] >= countM[modeIdxM] ? countP[modeIdxP] : countM[modeIdxM];
		}

		int[] mode = new int[3];
		int index = 0;
		for(int i=0; i<mode.length; i++){
			mode[i] = 9999;
		}

		for (int i = 4000; i > 0; i--) {
			if (countM[i] == modeCount) {
				mode[index++] = i * -1;
				if (index > 1) {
					break;
				}
			}
		}
		for (int i = 0; i <= 4000; i++) {
			if (countP[i] == modeCount) {
				mode[index++] = i;
				if (index > 1) {
					break;
				}
			}
		}

		System.out.println(mode[1] != 9999 ? mode[1] : mode[0]);
		System.out.println(arr[n - 1] - arr[0]);
	}
}
