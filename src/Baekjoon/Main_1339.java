/*
송지은_백준 알고리즘 1339번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_1339 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		HashMap<Character, Integer> alphabet = new HashMap<>();
		int[] num = new int[100];
		int idx = 0;

		for (int i = 0; i < N; i++) {
			String str = bufferedReader.readLine();

			int t = 1;
			for (int j = str.length() - 1; j >= 0; j--) {
				char c = str.charAt(j);

				if (alphabet.containsKey(c)) {
					num[alphabet.get(c)] += t;
				} else {
					num[idx] = t;
					alphabet.put(c, idx);
				}

				idx++;
				t = t * 10;
			}
		}

		Arrays.sort(num);

		int result = 0;
		int count = 9;
		for (int i = num.length - 1; i >= 0; i--) {
			result += num[i] * count;
			count--;
		}

		System.out.print(result);
	}
}
