/*
송지은_백준 알고리즘 5598번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5598 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str = bufferedReader.readLine();
		String result = "";

		for (char c : str.toCharArray()) {
			if (c == 'A') {
				result += "X";
			} else if (c == 'B') {
				result += "Y";
			} else if (c == 'C') {
				result += "Z";
			} else {
				result += (char)(c - 3);
			}
		}

		System.out.print(result);
	}
}
