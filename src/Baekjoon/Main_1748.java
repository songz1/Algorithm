/*
송지은_백준 알고리즘 1748번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1748 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String N = bufferedReader.readLine();

		int num = 9;
		int result = 0;
		for (int i = 1; i < N.length(); i++) {
			result += i * num;
			num *= 10;
		}

		result += (Integer.parseInt(N) - Math.pow(10, N.length() - 1) + 1) * N.length();

		System.out.print(result);
	}
}
