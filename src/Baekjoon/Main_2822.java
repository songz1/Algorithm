/*
송지은_백준 알고리즘 2822번

배열에 점수 받고 HashMap에 key:점수, value:인덱스 저장
-> 점수 sort
-> 높은 점수 5개 더하면서 result 배열에 HashMap으로 인덱스 불러와서 인덱스 저장
-> result sort
-> 출력
*/

package Baekjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main_2822 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] score = new int[8];
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < 8; i++) {
			score[i] = scanner.nextInt();
			hashMap.put(score[i], i+1);
		}

		Arrays.sort(score);

		int sum = 0;
		int[] result = new int[5];
		for (int i = 7; i > 2; i--) {
			sum += score[i];
			result[7-i] = hashMap.get(score[i]);
		}

		Arrays.sort(result);

		System.out.println(sum);
		for (int i = 0; i < 5; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
