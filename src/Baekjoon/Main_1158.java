/*
송지은_백준 알고리즘 1158번
*/

package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_1158 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int index = 0;
		while (list.size() > 0) {
			index = (index + k - 1) % list.size();
			result.add(list.get(index));
			list.remove(index);
		}

		System.out.print(result.toString().replace('[', '<').replace(']', '>'));
	}
}
